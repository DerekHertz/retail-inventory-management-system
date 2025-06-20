C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, 
the product names, and the names of the parts.

    edit shop name (line 19) to (now spans line 30 to 34) in mainscreen.html     
    <h1 class="letter-bounce">
        <span>D</span><span>e</span><span>r</span><span>e</span><span>k</span><span>'</span><span>s</span>
        <span> </span><span>G</span><span>a</span><span>r</span><span>d</span><span>e</span><span>n</span>
        <span> </span><span>K</span><span>i</span><span>t</span><span>s</span>
    </h1>

    edit parts (line 36) to <h2 class="retro-font">Garden Items and Supplies</h2> in mainscreen.html 
    edit product (line 68) to <h2 class="retro-font">Garden Kits</h2> in mainscreen.html 

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include 
navigation to and from the “About” page and the main screen.

    add about.html
    
    add nav (line 19-27) in mainscreen.html
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

    added buyKit button (line 97) in mainscreen.html <td><a th:href="@{/buyKit(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy</a>
    added buyKit to AddKitControl (line 177-198) - handles decrementing inv if inv is not 0, displays success or failure 
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

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.

    add minInv and maxInv fields to Part.java (line 33-36)
    @Min(value = 0, message = "Inventory value must be positive")
    int minInv;
    @Min(value = 0, message = "Inventory value must be positive")
    int maxInv;
    adjusted constructor to include minInv and maxInv (line 54-61)
    public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.inv = inv;
    this.minInv = minInv;
    this.maxInv = maxInv;
    }
    add getter and setter functions for minInv and maxInv in Part.java (line 95-101)
    public int getMinInv() { return this.minInv; }

    public void setMinInv(int minInv) { this.minInv = minInv; }

    public int getMaxInv() { return this.maxInv; }

    public void setMaxInv(int maxInv) { this.maxInv = maxInv; }

•  Modify the sample inventory to include the maximum and minimum fields.

    add minInv and maxInv to sample data in BootStrapData (lines 61-62, 70-71, 78-79, 87-88, 96-97, 105-106)

•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
    
    add minInv and maxInv inputs to InhousePartForm.html (line 27-33) and OutsourcedPartForm.html (line 28-33)
    <!-- set min inv -->
    <p><input type="text" path="minInv" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>


    <!-- set max inv -->
    <p><input type="text" path="maxInv" th:field="*{maxInv}" placeholder="Maximum Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>

•  Rename the file the persistent storage is saved to.

    rename persisten storage in application.properties (line 7)
    spring.datasource.url=jdbc:h2:file:~/DereksGKDatabasev_004

•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

    add InventoryValidator and ValidInventory interface to enforce min and max inventory by part, add @ValidInventory (line 20)
    into Part.java

    

    

