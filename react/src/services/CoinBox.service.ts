import http from "http-common";

class CoinBoxService {
  get() {
    return http.get("/coin-box");
  }

  insert(value: number) {
    return http.patch("/coin-box/insert/" + value);
  }

  release() {
    return http.patch("/coin-box/release");
  }
}

export default new CoinBoxService();
