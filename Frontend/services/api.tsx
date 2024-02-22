import Strings from "@/constants/Strings";
import axios from "axios";
import AsyncStorage from "@react-native-async-storage/async-storage";

const api = axios.create({
  baseURL: "http://192.168.100.142:8080",
});

api.interceptors.request.use(async (config) => {
  const token = AsyncStorage.getItem(Strings.token_jwt);
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
