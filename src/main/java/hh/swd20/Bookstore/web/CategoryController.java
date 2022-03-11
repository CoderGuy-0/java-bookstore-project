package hh.swd20.Bookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {
@Autowired
private CategoryRepository repository;

//RESTful service to get all categories
@RequestMapping(value="/categories", method = RequestMethod.GET)
public @ResponseBody List<Category> getCategoriesRest() {	
    return (List<Category>) repository.findAll();
}

//RESTful service to get category by id
@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long cId) {	
	return repository.findById(cId);
} 


// RESTful service to save new category
@RequestMapping(value="/categories", method = RequestMethod.POST)
public @ResponseBody Category saveBookRest(@RequestBody Category category) {	
	return repository.save(category);
}

 @RequestMapping(value="/categorylist", method=RequestMethod.GET)
public String ListCategories (Model model) 
{
	model.addAttribute("categoriea",repository.findAll());
	
	return "categorylist";
}
 
 @RequestMapping(value="/addC")
	public String addCategory (Model model)
	{
		model.addAttribute("category", new Category());
		return "addcategory";
	}
 
 @RequestMapping(value="/saveC", method=RequestMethod.POST)
	public String saveBook (Category category)
	{
		repository.save(category);
		return "redirect:categorylist";
	}
 
 @RequestMapping(value="/deleteC/{id}", method=RequestMethod.GET)
	public String deleteCategory (@PathVariable("id") Long categoryId, Model model)
	{
		repository.deleteById(categoryId);
		return "redirect:../categorylist";
	}
 

 
 
 
 
 
 


}
