public class TaskMain {
	public static void main(String[] args) {
		Task task = new Task();
		try{
		task.customFileWriter(task.customFileReader(task.pathToFile(task.enterFileOriginName())),task.enterFileFinallName());
		System.out.println("File is created");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
