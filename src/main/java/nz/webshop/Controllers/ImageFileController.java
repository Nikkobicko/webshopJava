package nz.webshop.Controllers;

import nz.webshop.Services.ImageServices;
import nz.webshop.models.FormWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ImageFileController {


    @Autowired
    ImageServices imageServices;

    @PostMapping("/uploadFile")
    public void multiUploadFileModel(@ModelAttribute FormWrapper model) {
        imageServices.setProduct(model);
    }

}
