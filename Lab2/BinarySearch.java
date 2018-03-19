public class BinarySearch {
	public static void main(String[] args) {
		int data[] = { 3, 6, 7, 10, 34, 56, 60 };
		int numberToFind = 10;
		int len = data.length, left = 0, right = len - 1;
		int medium = (right + left) / 2;
		while((left <= right) && (data[medium] !=numberToFind)){
			if(data[medium] < numberToFind) {
				left = medium + 1;
			}
			else if(data[medium] > numberToFind){
				right = medium -1;
			}
			medium = (right + left) / 2;
		}
		if(left <= right) {
			System.out.println(medium);
		}
		else {
			System.out.println(-1);
		}
	}
}
