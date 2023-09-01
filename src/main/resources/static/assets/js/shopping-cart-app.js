const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http){

  $scope.cart={
    items:[],

    add(id){

      var item = this.items.find((item) => item.id == id);
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
      } else {
        $http.get(`/rest/products/${id}`).then((resp) => {
          resp.data.qty = 1;
          this.items.push(resp.data);
          this.saveToLocalStorage();
        });
      }
    },

    remove(id){
      var index = this.items.findIndex((item) => item.id == id);
      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },

    clear() {
      this.items = [];
      this.saveToLocalStorage();
    },

    amt_of(item) {},

    get count(){
      return this.items
          .map((item) => item.qty)
          .reduce((total, qty) => (total += qty), 0);
    },

    get amount(){
      return this.items
          .map((item) => item.qty*item.price)
          .reduce((total, qty) => (total += qty), 0);
    },

    saveToLocalStorage() {
      var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
    },

    loadFromLocalStorage() {
      var json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    }
  }

  $scope.cart.loadFromLocalStorage();
$scope.createDate= new Date();
  	$scope.order = {
		get account() {
			return { username: $auth.user.username }
		},
		
		address: "",
		get orderDetails() {
			return $cart.items.map(item => {
				return {
					product: { id: item.id },
					image:item.image,
					price: item.price,
					createDate: new Date(),
					quantity: item.qty
				}
			});
		},
		purchase() {
			var order = angular.copy(this);
			// Thực hiện đặt hàng
			$http.post("/rest/historys", order).then(resp => {
				alert("Đặt hàng thành công!");
				$cart.clear();
				location.href = "/user/product-detail/" + resp.data.id;
			}).catch(error => {
				alert("Đặt hàng lỗi!")
				console.log(error)
			})
		}
		}

})


