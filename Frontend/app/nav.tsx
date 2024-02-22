import { Stack } from "expo-router";
import LoginScreen from "./pages/auth/login";
import { useApi } from "@/contexts/ApiContext";

export default function NavStack() {
  const { isLogged } = useApi();
  return (
    <>
      {!isLogged ? (
        <LoginScreen />
      ) : (
        <Stack>
          <Stack.Screen name="(tabs)" options={{ headerShown: false }} />
          <Stack.Screen name="modal" options={{ presentation: "modal" }} />
        </Stack>
      )}
    </>
  );
}
