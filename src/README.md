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