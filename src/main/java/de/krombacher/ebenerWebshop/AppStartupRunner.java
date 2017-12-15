package de.krombacher.ebenerWebshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import de.krombacher.ebenerWebshop.domain.Article;
import de.krombacher.ebenerWebshop.domain.Category;
import de.krombacher.ebenerWebshop.domain.CostLocationAssignment;
import de.krombacher.ebenerWebshop.domain.Employee;
import de.krombacher.ebenerWebshop.domain.StorageLocation;
import de.krombacher.ebenerWebshop.repository.ArticleRepository;
import de.krombacher.ebenerWebshop.repository.CategoryRepository;
import de.krombacher.ebenerWebshop.repository.CollectiveCostLocationRepository;
import de.krombacher.ebenerWebshop.repository.CostLocationAssignmentRepository;
import de.krombacher.ebenerWebshop.repository.EmployeeRepository;
import de.krombacher.ebenerWebshop.repository.StorageLocationRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

	@Autowired
	ArticleRepository articleRepo;

	@Autowired
	CategoryRepository catRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	StorageLocationRepository storageRepo;

	@Autowired
	CostLocationAssignmentRepository costLocAsignRepo;

	@Autowired
	CollectiveCostLocationRepository costLocationRepo;

	private Map<String, StorageLocation> storageLocationMap = null;

	private Map<String, Category> categoryMap = null;

	private Map<String, Employee> employeeMap = null;

	private Map<String, CostLocationAssignment> costLocAsignMap = null;

	@Autowired
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Your application started with option names : {}", args.getOptionNames());

		File file = new File("C:\\Users\\PraktikantKIV\\Desktop\\articles.csv");
		File employeeFile = new File("C:\\Users\\PraktikantKIV\\Desktop\\users.csv");
		File costFile = new File("C:\\Users\\PraktikantKIV\\Desktop\\costLocations.csv");

		String delimter = ";";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		BufferedReader employeeReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(employeeFile), "UTF-8"));
		BufferedReader costReader = new BufferedReader(new InputStreamReader(new FileInputStream(costFile), "UTF-8"));

		String line;

		try {
			// Fill Article Database
			List<Article> articleList = new ArrayList<Article>();
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] exploit = line.split(delimter);
				if (exploit[0].charAt(0) == '\u0000')
					exploit[0] = exploit[0].substring(1);

				if (exploit.length == 8) {
					Article article = new Article();
					article.setArticlenr(Long.parseLong(exploit[0]));
					article.setSerialNr(exploit[1]);
					article.setDescription(exploit[2]);
					article.setStock(Integer.parseInt(exploit[3]));
					article.setEancode(exploit[4]);

					if (exploit[5].equals("1"))
						article.setVisible(true);
					else
						article.setVisible(false);

					article.setStorageLocation(getStorageLocation(exploit[6]));
					article.setCategory(getCategory(exploit[7]));

					articleList.add(article);
				} else {
					logger.info(line);
				}
			}

			articleRepo.save(articleList);

			// Fill Employee Database
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeReader.readLine();
			while ((line = employeeReader.readLine()) != null) {
				String[] exploit = line.split(delimter);
				if (exploit[0].charAt(0) == '\u0000')
					exploit[0] = exploit[0].substring(1);

				if (exploit.length == 6) {
					Employee employee = new Employee();
					employee.setPersNr(exploit[0]);
					employee.setName(exploit[1]);
					employee.setFirstname(exploit[2]);
					employee.setMail(exploit[3]);
					employee.setPhoneNr(exploit[4]);
					employee.setCostLocation(exploit[4]);

					// employee.setStorageLocation(getStorageLocation(exploit[6]));

					employeeList.add(employee);
				} else {
					logger.info(line);
				}
			}

			employeeRepo.save(employeeList);

			// Fill CostLocationAssignment Database

			List<CostLocationAssignment> costList = new ArrayList<CostLocationAssignment>();
			costReader.readLine();
			while ((line = costReader.readLine()) != null) {
				String[] exploit = line.split(delimter);

				if (exploit.length == 3) {
					CostLocationAssignment costLocationAssignment = new CostLocationAssignment();
					Employee employee = employeeRepo.findByPersNr(exploit[0]);
					costLocationAssignment.setEmployee(employee);
					costLocationAssignment.setCostLocation(exploit[1]);
					costList.add(costLocationAssignment);
				} else {
					logger.info(line);
				}
			}

			costLocAsignRepo.save(costList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Category getCategory(String categoryName) {
		if (categoryMap == null) {
			categoryMap = new HashMap<String, Category>();

			List<Category> catList = (List<Category>) catRepo.findAll();

			for (Category c : catList) {
				categoryMap.put(c.getName(), c);
			}
		}

		Category cat = categoryMap.get(categoryName);

		if (cat != null)
			return cat;

		cat = new Category();
		cat.setName(categoryName);

		cat = catRepo.save(cat);

		categoryMap.put(cat.getName(), cat);

		return cat;

	}

	public StorageLocation getStorageLocation(String locationName) {
		if (storageLocationMap == null) {
			storageLocationMap = new HashMap<String, StorageLocation>();
			List<StorageLocation> storageList = (List<StorageLocation>) storageRepo.findAll();

			for (StorageLocation location : storageList) {
				storageLocationMap.put(location.getLocationName(), location);
			}
		}

		StorageLocation location = storageLocationMap.get(locationName);

		if (location != null)
			return location;

		location = new StorageLocation();
		location.setLocationName(locationName);

		location = storageRepo.save(location);

		storageLocationMap.put(locationName, location);

		return location;
	}
}
