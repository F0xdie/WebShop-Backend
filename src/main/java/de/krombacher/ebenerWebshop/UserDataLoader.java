//package de.krombacher.ebenerWebshop;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import de.krombacher.ebenerWebshop.domain.Employee;
//
//public class UserDataLoader {
//	logger.info("Your application started with option names : {}",
//	args.getOptionNames());
//
//	private Map<String, Employee> employeeMap = null;
//
//	File employeeFile = new File("C:\\Users\\PraktikantKIV\\Desktop\\user.csv");
//	String delimter = ";";
//	BufferedReader employeeReader = new BufferedReader(
//			new InputStreamReader(new FileInputStream(employeeFile), "UTF-8"));
//	String line;
//
//	List<Employee> employeeList = new ArrayList<Employee>();employeeReader.readLine();while((line=employeeReader.readLine())!=null)
//	{
//		String[] exploit = line.split(delimter);
//		if (exploit[0].charAt(0) == '\u0000')
//			exploit[0] = exploit[0].substring(1);
//
//		if (exploit.length == 6) {
//			Employee employee = new Employee();
//			employee.setPersNr(exploit[0]);
//			employee.setName(exploit[1]);
//			employee.setFirstname(exploit[2]);
//			employee.setMail(exploit[3]);
//			employee.setPhoneNr(exploit[4]);
//			employee.setCostLocation(exploit[4]);
//			
//			// employee.setStorageLocation(getStorageLocation(exploit[6]));
//			
//			employeeList.add(employee);
//		} else {
//			logger.info(line);
//		}
//	}
//
//	employeeRepo.save(employeeList);
//
//}

//public StorageLocation getStorageLocation(String locationName) {
//	if (storageLocationMap == null) {
//		storageLocationMap = new HashMap<String, StorageLocation>();
//		List<StorageLocation> storageList = (List<StorageLocation>) storageRepo.findAll();
//
//		for (StorageLocation location : storageList) {
//			storageLocationMap.put(location.getLocationName(), location);
//		}
//	}
//
//	StorageLocation location = storageLocationMap.get(locationName);
//
//	if (location != null)
//		return location;
//
//	location = new StorageLocation();
//	location.setLocationName(locationName);
//
//	location = storageRepo.save(location);
//
//	storageLocationMap.put(locationName, location);
//
//	return location;
//	}
//}
