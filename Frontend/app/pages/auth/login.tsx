import { useApi } from "@/contexts/ApiContext";
import api from "@/services/api";
import React, { useState } from "react";
import {
  View,
  TextInput,
  TouchableOpacity,
  Text,
  Platform,
} from "react-native";

const LoginScreen = () => {
  const [username, setUsername] = useState("admin@admin.com");
  const [password, setPassword] = useState("password123");
  const { login, setIsLoading } = useApi();

  const handleLogin = async () => {
    setIsLoading(true);
    try {
      const { data } = await api.post("/usuarios/login", {
        email: username,
        password,
      });
      login(data.token);
      setIsLoading(false);
    } catch {
      setIsLoading(false);
    }
  };

  return (
    <View className={`flex-1 justify-center items-center bg-gray-200`}>
      <View
        className={`${
          Platform.OS == "web" ? "w-2/6" : "w-4/5"
        } bg-white p-8 rounded-sm`}
      >
        <TextInput
          className={`border-b-2 text-lg border-gray-300 mb-6 p-2`}
          onChangeText={setUsername}
          value={username}
        />
        <TextInput
          className={`border-b-2 text-lg border-gray-300 mb-12 p-2`}
          secureTextEntry
          onChangeText={setPassword}
          value={password}
        />
        <TouchableOpacity
          className={`bg-red-500 p-2 rounded-sm items-center`}
          onPress={handleLogin}
        >
          <Text className={`text-white text-lg`}>Vamos Lá!</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

export default LoginScreen;
