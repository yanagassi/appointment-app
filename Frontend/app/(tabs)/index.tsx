import { Pressable, StyleSheet } from "react-native";

import { Text, View } from "@/components/Themed";
import { Link } from "expo-router";

export default function TabOneScreen() {
  return (
    <View style={styles.container}>
      <Text className="font-bold text-4xl mb-20">Tela Inicio</Text>

      <Link href="/modal" asChild>
        <Pressable>
          <Text className="font-bold text-1xl">Ativar Modal</Text>
        </Pressable>
      </Link>
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
