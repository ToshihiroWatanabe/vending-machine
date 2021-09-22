import Admin from "pages/Admin";
import VendingMachine from "pages/VendingMachine";
import { Route, Switch } from "react-router-dom";

const App = () => {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/">
          <VendingMachine />
        </Route>
        <Route exact path="/admin">
          <Admin />
        </Route>
      </Switch>
    </div>
  );
};

export default App;
