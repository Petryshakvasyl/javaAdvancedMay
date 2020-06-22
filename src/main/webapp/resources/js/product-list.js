function buyNow(id) {
    console.log('by product with id ' + id);
}

async function getProducts() {
   let result = await fetch("/products")
   let products = result.json();

    for (let product in products) {

    }

}