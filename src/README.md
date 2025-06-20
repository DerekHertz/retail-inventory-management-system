C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, 
the product names, and the names of the parts.
    edit shop name (line 19) to (now spans line 30 to 34)     
<h1 class="letter-bounce">
    <span>D</span><span>e</span><span>r</span><span>e</span><span>k</span><span>'</span><span>s</span>
    <span> </span><span>G</span><span>a</span><span>r</span><span>d</span><span>e</span><span>n</span>
    <span> </span><span>K</span><span>i</span><span>t</span><span>s</span>
</h1>

    edit parts (line 36) to <h2 class="retro-font">Garden Items and Supplies</h2>
    edit product (line 68) to <h2 class="retro-font">Garden Kits</h2>

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include 
navigation to and from the “About” page and the main screen.

line 19-27 in mainscreen.html
<nav class="navbar navbar-expand-lg navbar-light mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Derek's Garden Kits</a>
        <div class="navbar-nav">
            <a class="nav-link" href="/">Home</a>
            <a class="nav-link active" href="/about">About</a>
        </div>
    </div>
</nav>

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five 
products in your sample inventory and should not overwrite existing data in the database.

add 5 parts and 5 products into BootStrapData if product and part list are empty (line 54-131)

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

    added buyKit button (line 97) <td><a th:href="@{/buyKit(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy</a>
    added buyKit to AddKitControll (line 177-198) - handles decrementing inv if inv is not 0, displats success or failure 
    message based on current inv
        @GetMapping("/buyKit")
    public String buyKit(@RequestParam("productID") int theId, Model theModel) {
        // initialize productService through spring context
        ProductService productService = context.getBean(ProductServiceImpl.class);
        // create product object called kit
        Product kit=productService.findById(theId);
        // create variable to store value of inv
        int inv =  kit.getInv();
        // check if inv is 0
        if (inv == 0) {
            // return failed.html page
            return "failed";
        } else {
            // reduce inv by one
            inv -= 1;
            // set new value of kit inv
            kit.setInv(inv);
            // save kit object
            productService.save(kit);
            // return success.html page
            return "success";
        }

    

