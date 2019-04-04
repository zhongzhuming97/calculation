package Main;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Utils.Analysis;
import Utils.CreateExpression;
import Utils.InfixToSuffix;

/**
 * 
 * @author apple
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		times();
	}

	public static void test() {
		/*
		String a = InfixToSuffix.toSuffix("55.6+4*60/2+33+(4.7*5.6)/5");// 传入 一串 算数公式
		System.out.println(a);
		System.out.println(InfixToSuffix.dealEquation(a));//计算得出结果
		Random rand =new Random();
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextInt(1000));
		 */
		int count=10;
		while(count>0) {
		String s=CreateExpression.createRandomExpression();
		System.out.println(s);
		Analysis analysis = new Analysis(s);
		analysis.analysis();
		count--;
		}
	}
	public static void times(){
		Timer timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int i=0;
				System.out.println(i++);
			}
		},3000,3000);
	}


/*
	@RequestMapping(value = "/solvePicture", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request) {
		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		for(MultipartFile multipartFile:files) {
			System.out.println(multipartFile.toString());
		}
		System.out.println(files.size());
		String name = params.getParameter("name");// 参数与安卓addFormDataPart的第一个参数对应
		System.out.println("name:" + name);
		String id = params.getParameter("id");
		System.out.println("id:" + id);
		Map<String, String> urlMap = new HashMap<>();

		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(
							new FileOutputStream(new File("src/main/resources/images/" + file.getOriginalFilename())));// 存在项目根目录下
					stream.write(bytes);
					stream.close();
					urlMap.put(SERVER_URL + "resource/images/", file.getOriginalFilename());
				} catch (Exception e) {
					stream = null;
					return e.toString();
				}
			} else {
				return "空";
			}
		}
		return "成功";
	}



	
 */






}
