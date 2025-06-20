package com.example.demo.bootstrap;

import com.example.demo.domain.HandCrafted;
import com.example.demo.domain.Product;
import com.example.demo.domain.Supplier;
import com.example.demo.repositories.SupplierRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final SupplierRepository supplierRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        // check if part or product list is empty to set sample inv.
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // default parts for garden kits
            HandCrafted ceramicPot = new HandCrafted();
            ceramicPot.setName("5 Gallon Ceramic Pot");
            ceramicPot.setPrice(9.99);
            ceramicPot.setInv(40);
            ceramicPot.setPartId(1);
            ceramicPot.setMinInv(10);
            ceramicPot.setMaxInv(100);
            partRepository.save(ceramicPot);

            HandCrafted cedarPanels = new HandCrafted();
            cedarPanels.setName("Cedar Planter Box Panels");
            cedarPanels.setPrice(5.99);
            cedarPanels.setInv(500);
            cedarPanels.setPartId(2);
            cedarPanels.setMinInv(100);
            cedarPanels.setMaxInv(1000);
            partRepository.save(cedarPanels);

            Supplier shovel = new Supplier();
            shovel.setName("Shovel");
            shovel.setPrice(10.99);
            shovel.setInv(100);
            shovel.setMinInv(10);
            shovel.setMaxInv(200);
            shovel.setCompanyName("Shovel Co.");
            partRepository.save(shovel);

            Supplier flowerSeeds = new Supplier();
            flowerSeeds.setName("Flower Seeds");
            flowerSeeds.setPrice(3.99);
            flowerSeeds.setInv(100);
            flowerSeeds.setMinInv(50);
            flowerSeeds.setMaxInv(500);
            flowerSeeds.setCompanyName("Seeds Co..");
            partRepository.save(flowerSeeds);

            Supplier vegetableSeeds = new Supplier();
            vegetableSeeds.setName("Vegetable Seeds");
            vegetableSeeds.setPrice(3.99);
            vegetableSeeds.setInv(100);
            vegetableSeeds.setMinInv(50);
            vegetableSeeds.setMaxInv(500);
            vegetableSeeds.setCompanyName("Seeds Co.");
            partRepository.save(vegetableSeeds);

            Supplier planterHardware = new Supplier();
            planterHardware.setName("Planter Hardware");
            planterHardware.setPrice(5.99);
            planterHardware.setInv(200);
            planterHardware.setMinInv(100);
            planterHardware.setMaxInv(1000);
            planterHardware.setCompanyName("Hardware Co.");
            partRepository.save(planterHardware);

            // 5 default kits
            Product seedKit = new Product();
            seedKit.setName("Seed Kit");
            seedKit.setPrice(6.99);
            seedKit.setInv(30);
            productRepository.save(seedKit);

            Product flowerKit = new Product();
            flowerKit.setName("Flower Kit");
            flowerKit.setPrice(15.99);
            flowerKit.setInv(10);
            productRepository.save(flowerKit);

            Product vegetableKit = new Product();
            vegetableKit.setName("Vegetable Kit");
            vegetableKit.setPrice(15.99);
            vegetableKit.setInv(10);
            productRepository.save(vegetableKit);

            Product planterKit = new Product();
            planterKit.setName("Planter Kit");
            planterKit.setPrice(60.99);
            planterKit.setInv(15);
            productRepository.save(planterKit);

            Product potKit = new Product();
            potKit.setName("Garden Kit");
            potKit.setPrice(99.99);
            potKit.setInv(10);
            productRepository.save(potKit);

            System.out.println("🌱 Sample garden inventory has been planted!");

        }

        List<Supplier> suppliers =(List<Supplier>) supplierRepository.findAll();
        for(Supplier part: suppliers){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
