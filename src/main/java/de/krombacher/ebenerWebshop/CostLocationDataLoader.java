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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import de.krombacher.ebenerWebshop.domain.CollectiveCostLocation;
//
//public class CostLocationDataLoader {
//
//	private static final Logger logger = LoggerFactory.getLogger(CostLocationDataLoader.class);
//	logger.info("Your application started with option names : {}",
//			args.getOptionNames());
//
//			private Map<String, CollectiveCostLocation> costMap = null;
//
//			File costFile = new File("C:\\Users\\PraktikantKIV\\Desktop\\costLocation.csv");
//			String delimter = ";";
//			BufferedReader costReader = new BufferedReader(
//					new InputStreamReader(new FileInputStream(costFile), "UTF-8"));
//			String line;
//
//			List<CollectiveCostLocation> costList = new ArrayList<CollectiveCostLocation>();costReader.readLine();while((line=costReader.readLine())!=null)
//			{
//				String[] exploit = line.split(delimter);
//				if (exploit[0].charAt(0) == '\u0000')
//					exploit[0] = exploit[0].substring(1);
//
//				if (exploit.length == 3) {
//					CollectiveCostLocation costLocation = new CollectiveCostLocation();
//					
//					
//					costList.add(costLocation);
//				} else {
//					logger.info(line);
//				}
//			}
//
//			costRepo.save(costList);
//
//		}
//
//}
