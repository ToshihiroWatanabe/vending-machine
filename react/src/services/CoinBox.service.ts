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

  adjust(money: number) {
    return http.post("/coin-box/adjust/" + money);
  }

  withdraw(money: number) {
    return http.post("/coin-box/withdraw/" + money);
  }
}

export default new CoinBoxService();
