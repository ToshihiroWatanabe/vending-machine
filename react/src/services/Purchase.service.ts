import http from "http-common";

class PurchaseService {
  post(id: number) {
    return http.post("/purchase/" + id);
  }
}

export default new PurchaseService();
