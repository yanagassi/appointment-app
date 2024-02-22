import { Button, StyleSheet, TouchableOpacity } from "react-native";

import { Text, View } from "@/components/Themed";
import { useApi } from "@/contexts/ApiContext";

export default function Perfil() {
  const { logout } = useApi();
  return (
    <View style={styles.container}>
      <Text className="font-bold text-2xl">Perfil</Text>

      <TouchableOpacity onPress={() => logout()} className="mt-4">
        <Text>Sair</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
  },
  title: {
    fontSize: 20,
    fontWeight: "bold",
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: "80%",
  },
});
