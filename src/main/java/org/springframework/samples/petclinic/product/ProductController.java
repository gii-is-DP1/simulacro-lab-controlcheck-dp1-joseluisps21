package org.springframework.samples.petclinic.product;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    private static final String VIEW_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    @GetMapping(path = "/create")
    public String initCreationForm(ModelMap modelMap) {
        String view = VIEW_PRODUCTS_CREATE_OR_UPDATE_FORM;
        modelMap.addAttribute("product", new Product());
        modelMap.addAttribute("productType", productService.findAllProductTypes());
        return view;
    }

    @PostMapping(path = "/create")
    public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
        String view = "welcome";
        if (result.hasErrors()) {
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("productType", productService.findAllProductTypes());
            return VIEW_PRODUCTS_CREATE_OR_UPDATE_FORM;
        } else {
            // creating card
            productService.save(product);
            modelMap.addAttribute("message", "Product succesfully saved!");
        }
        return view;
    }
}
