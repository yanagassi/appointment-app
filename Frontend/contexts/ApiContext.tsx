// ApiContext.tsx
import Strings from "@/constants/Strings";
import React, {
  createContext,
  useContext,
  useState,
  useEffect,
  ReactNode,
} from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { jwtDecode } from "@/helpers/jwt";
import LoadingPage from "@/components/LoadingPage";

interface User {
  name: string;
}

interface ApiContextProps {
  user: User | null;
  login(token: string): void;
  isLogged: boolean;

  isLoading: boolean;
  setIsLoading(status: boolean): void;
  logout(): void;
}

const ApiContext = createContext<ApiContextProps | undefined>(undefined);

interface ApiProviderProps {
  children: ReactNode;
}

export const ApiProvider: React.FC<ApiProviderProps> = ({ children }) => {
  const [user, setUser] = useState<User | null>(null);
  const [isLogged, setIsLogged] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const loadUserFromStorage = async () => {
      try {
        const token = await AsyncStorage.getItem(Strings.token_jwt);
        if (token) {
          const myUser = jwtDecode<User>(token);
          setUser(myUser);
          setIsLogged(true);
        }
      } catch (error) {
        console.error("Error loading user from storage:", error);
      }
      setIsLoading(false);
    };

    loadUserFromStorage();
  }, []);

  const logout = async () => {
    await AsyncStorage.setItem(Strings.token_jwt, "");
    setUser(null);
    setIsLogged(false);
  };

  const login = async (token: string) => {
    if (token) {
      try {
        await AsyncStorage.setItem(Strings.token_jwt, token);
        const myUser = jwtDecode<User>(token);

        setUser(myUser);
        setIsLogged(true);
      } catch (error) {
        console.error("Error storing token:", error);
      }
    }
  };

  return (
    <ApiContext.Provider
      value={{ user, logout, login, isLogged, isLoading, setIsLoading }}
    >
      {!isLoading ? children : <LoadingPage />}
    </ApiContext.Provider>
  );
};

export const useApi = (): ApiContextProps => {
  const context = useContext(ApiContext);
  if (!context) {
    throw new Error("useApi must be used within an ApiProvider");
  }
  return context;
};
