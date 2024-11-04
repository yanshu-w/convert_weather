import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useCounterStore = defineStore("counter", () => {
  const userInfo = ref({});
  const token = ref('')

  const setUserInfo = (token) => {
    token.value = token;
  };

  return { setUserInfo };
},{
  persist: true //持久化存储
});
