/**
 * 
 */
package com.gcit.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.Branch;

import dao.BookCopiesDAO;
import dao.BookDAO;
import dao.BranchDAO;



/**
 * @author tejassrinivas
 *
 */
@Component
@CrossOrigin
@RestController
public class LibrarianService {
		
	@Autowired
	BranchDAO brDao;
	
	@Autowired
	BookDAO bDao;
	
	@Autowired
	BookCopiesDAO bcDao;
	
	
	@RequestMapping(value = "/branches", produces="application/json")
	public List<Branch> readBranches() throws SQLException {
		System.out.println("Entering here inside admin br");
		return brDao.readAllBranches();
	}
	
	@RequestMapping(value= "/branches/{branchId}", produces="application/json")
	public Branch readBranchByPk(@PathVariable Integer branchId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Entering once Branch by PK with id : " + branchId);
		return	brDao.readBranchByPK(branchId);
	}
	
	@RequestMapping(value = "/booksbybranch", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Book> readBooksByBranch(@RequestBody Branch branch) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
			return bDao.readBooksByBranches(branch);
	}
	
	@RequestMapping(value = "/branchbookcount/{branchId}/{bookId}", method = RequestMethod.GET, produces="application/json")
	public Integer readBookCountInBranch(@PathVariable Integer branchId,@PathVariable  Integer bookId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		BookCopies bookCopies = bcDao.readBookCopiesByBothIds(branchId, bookId);
		return bcDao.readTotalBookCopies(bookCopies);
	}
	
	@Transactional
	@RequestMapping(value = "/bookcopies", method = RequestMethod.POST, produces="application/json")
	public void saveBookCopies(@RequestBody BookCopies bookCopies) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			bcDao.updateCopies(bookCopies);
	}
	
	@RequestMapping(value = "/branchentry", method = RequestMethod.POST, produces="application/json")
	public void updateBranch(@RequestBody Branch branch) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			brDao.updateBranch(branch);
	}
}
