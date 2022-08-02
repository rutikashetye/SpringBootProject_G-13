package com.lti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AadharPicDto;
import com.lti.dto.AddProductDto;
import com.lti.dto.AddproductResponseDto;
import com.lti.dto.PanPicDto;
import com.lti.dto.ProductPicDto;
import com.lti.dto.RegResponseDto;
import com.lti.dto.RetailerLoginDto;
import com.lti.dto.UpdateProductDto;
import com.lti.dto.UpdateRetailerDto;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.service.RetailerService;


@RestController
@RequestMapping("/paark")
@CrossOrigin("*")
public class RetailerController {

	@Autowired
	RetailerService service;
	
	
	@Autowired
	RetailerService retailerService;
	
	@GetMapping("/viewAllProductsById/{retailerId}")
	public List<Product> viewAllProductsById(@PathVariable int retailerId) {
            return service.viewAllProductsById(retailerId);
        }
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public Item addproductTocart(@RequestBody Item item) {
		Item item2=service.AddOrUpdateProdcutToCart(item); 
	    return item2;
	}
			
//	
//	@RequestMapping(value="/retailerSignup",method=RequestMethod.POST)
//	public RegResponseDto signup(@RequestBody Retailer retailer) {
//		RegResponseDto regResponseDto=service.retailerSignup(retailer);
//		return regResponseDto;
//		
//		
//	}
	
//	@PostMapping("/retailerLogin")
//	public boolean login(@RequestBody RetailerLoginDto loginData) {
//		boolean isValid=retailerService.retailerLogin(loginData.getRetailerId(),loginData.getRetailerPassword());
//				return isValid;
//	}
	
	
	
	@GetMapping("/productimageDownload")
    public String productImageDownload(@RequestParam("productId") int productId, HttpServletRequest request) {
        //fetching customer data from the database
        Product product = retailerService.getProductByProductId(productId);
        //reading the project's deployed folder location
        String projPath = request.getServletContext().getRealPath("/");
        String tempDownloadPath = projPath + "/downloads/";
        //creating a folder within the project where we will place the profile pic of the customer getting fetched
        File f = new File(tempDownloadPath);
        if(!f.exists())
            f.mkdir();
        String targetFile = tempDownloadPath + product.getProductImage();
        
        //the original location where the uploaded images are present
        String uploadedImagesPath = "d:/uploads/";
        String sourceFile = uploadedImagesPath + product.getProductImage();
        
        try {
            FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            //maybe for this customer there is no profile pic
        }
        
        return "download product done";
    }
	
	
	
	
	
	@RequestMapping(value="/retailerSignup",method=RequestMethod.POST)
	public RegResponseDto signup(@RequestBody Retailer retailer) {
		RegResponseDto regResponseDto=retailerService.retailerSignup(retailer);
		return regResponseDto;
		
		
	}
	
	@PostMapping("/retailerLogin")
	public boolean login(@RequestBody RetailerLoginDto loginData) {
		boolean isValid=retailerService.retailerLogin(loginData.getRetailerId(),loginData.getRetailerPassword());
	    return isValid;
	}
	

	
	
	
	
	@PostMapping("/aadharpic-upload")
    public String upload(AadharPicDto aadharPicDto) {
        String imageUploadLocation = "d:/uploads/";
        String fileName = aadharPicDto.getAadharPic().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        try {
            FileCopyUtils.copy(aadharPicDto.getAadharPic().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Retailer retailer = retailerService.getRetailer(aadharPicDto.getRetailerId());
        retailer.setAadharCard(fileName);
        UpdateRetailerDto updateRetailer= retailerService.updateRetailer(retailer);
        if(updateRetailer!=null)
            return "File uploaded";
        
        return "Upload failed";
    }
	
	@PostMapping("/panpic-upload")
    public String upload(PanPicDto panPicDto) {
        String imageUploadLocation = "d:/uploads/";
        String fileName = panPicDto.getPanPic().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        try {
            FileCopyUtils.copy(panPicDto.getPanPic().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Retailer retailer = retailerService.getRetailer(panPicDto.getRetailerId());
        retailer.setPanCard(fileName);
        UpdateRetailerDto updateRetailer= retailerService.updateRetailer(retailer);
        if(updateRetailer!=null)
            return "File uploaded";
        
        return "Upload failed";
    }
	
	@GetMapping("/profile")
    public String profile(@RequestParam("retailerId") int retailerId, HttpServletRequest request) {
        //fetching customer data from the database
        Retailer retailer = retailerService.getRetailer(retailerId);
        //reading the project's deployed folder location
        String projPath = request.getServletContext().getRealPath("/");
        String tempDownloadPath = projPath + "/downloads/";
        //creating a folder within the project where we will place the profile pic of the customer getting fetched
        File f = new File(tempDownloadPath);
        if(!f.exists())
            f.mkdir();
        String targetFile1 = tempDownloadPath + retailer.getAadharCard();
       String targetFile2 = tempDownloadPath + retailer.getPanCard();
        
        //the original location where the uploaded images are present
        String uploadedImagesPath = "d:/uploads/";
        String sourceFile1 = uploadedImagesPath +retailer.getAadharCard();
      String sourceFile2 = uploadedImagesPath +retailer.getPanCard();
        
        try {
            FileCopyUtils.copy(new File(sourceFile1), new File(targetFile1));
          FileCopyUtils.copy(new File(sourceFile2), new File(targetFile2));
        } catch (IOException e) {
            e.printStackTrace();
            //maybe for this customer there is no profile pic
        }
        
        return "downloaded retailer documments";
    }
	
	@GetMapping("/viewAllRetailer")
	public List<Retailer> viewAllRetailers() {
		return retailerService.viewAllRetailers();
	}
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST)
	public AddproductResponseDto addProduct(@RequestBody AddProductDto product) {
		System.out.println(product.getRetailerId());
		 AddproductResponseDto response =retailerService.addProduct(product); 
	    return response;
	}
	
	@PostMapping("/productpic-upload")
    public String upload(ProductPicDto productPicDto) {
        String imageUploadLocation = "d:/uploads/";
        String fileName = productPicDto.getProductPic().getOriginalFilename();
        String targetFile = imageUploadLocation + fileName;
        try {
            FileCopyUtils.copy(productPicDto.getProductPic().getInputStream(), new FileOutputStream(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        Product dto = retailerService.getProductByProductId(productPicDto.getProductId());
        System.out.println(dto.getProductId());
        dto.setProductImage(fileName);
       
        AddProductDto p=new AddProductDto();
        p.setRetailerId(productPicDto.getRetailerId());
        p.setProduct(dto);
        UpdateProductDto updateProduct=retailerService.updateProduct(p);
               if(updateProduct!=null)
            return "Product Image uploaded";
        
        return "Could not upload Product Image";
    }

	
	


	
	@GetMapping("/viewProductById/{productId}")
	public Product searchProduct(@PathVariable int productId)
	{
		return service.getProductByProductId(productId);
	}
	
	
	@GetMapping(value="/retailer/{retailerId}")
	public Retailer searchRetailer(@PathVariable int retailerId) {
		return service.getRetailer(retailerId);
	}
	
	@GetMapping(value = "/view-productByCategory/{category}")
	public List<Product> viewProductBasedOnCategory(@PathVariable String category) {
		return service.viewProductBasedOnCategory(category);
	}
		
	@GetMapping("/is_notApprovedRetailer")
	public List<Retailer> viewAllRetailer() {
            return service.viewAllRetailer();
        }
	
	@GetMapping("/is_notApprovedProducts")
	public List<Product> viewAllProducts() {
            return service.viewAllProducts();
        }
	

	
	
	
	
	
	
	
	
//	@RequestMapping(value="/retailerSignup",method=RequestMethod.POST)
//	public RegResponseDto signup(@RequestBody Retailer retailer) {
//		RegResponseDto regResponseDto=service.retailerSignup(retailer);
//		return regResponseDto;
//		
//		
//	}
	
//	@PostMapping("/retailerLogin")
//	public boolean login(@RequestBody RetailerLoginDto loginData) {
//		boolean isValid=retailerService.retailerLogin(loginData.getRetailerId(),loginData.getRetailerPassword());
//				return isValid;
//	}
	
	
}
