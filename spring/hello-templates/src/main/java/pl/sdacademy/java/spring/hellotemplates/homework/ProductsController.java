package pl.sdacademy.java.spring.hellotemplates.homework;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    //[GET] /products
    //Widok listy produktów (nazwy jako linki prowadzące na stronę produktu) + link do formularza
    @GetMapping
    public String getProducts(Model model) {
        model
                .addAttribute("title", "Lista produktów")
                .addAttribute("products", productsService.getProducts());

        return "homework/products";
    }

    //[GET] /products/{id}
    //Widok szczegółowy produktu
    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id, Model model) {
        final Product product = productsService.getProduct(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model
                .addAttribute("title", product.getName())
                .addAttribute("product", product);

        return "homework/product-details";
    }

    //[POST] /products
    //Dodawanie produktu, po wykonaniu - pokazanie listy jak wyżej
    //Obsługa przyjmowanych danych dowolna, może być z @RequestParam i mapą bądź pojedyncze wartości
    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productsService.addProduct(product);
        return "redirect:products";
    }

    //[POST] /products/add
    //Formularz dodawania produktu. Uwaga, model może nie być potrzebny - wtedy obsłużyć inaczej
    @GetMapping("/add")
    public String getProductForm(Model model) {
        model.addAttribute("title", "Dodawanie produktu");
        return "homework/products-add";
    }
}
