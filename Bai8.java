package com.hoanghiep.onthi;

import java.util.ArrayList;
import java.util.List;

public class Bai8 {
	
	public static boolean checkThuanNghich(int n) {
        List<Integer> listNumbers = new ArrayList<>();
        // phân tích số n thành các chữ số và lưu vào listNumbers
        do {
            listNumbers.add(n % 10);
            n = n / 10;
        } while (n > 0);
        // kiểm tra tính thuận nghịch
        int size = listNumbers.size();
        for (int i = 0; i < (size/2); i++) {
            if (listNumbers.get(i) != listNumbers.get(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println("Liet ke tat ca so thuan nghich doc co 6 chu so");
				
		System.out.println("so nguyen to nho hon n: ");
		int count = 0;
		for (int i=100000; i<=999999; i++) {
			if(checkThuanNghich(i)) {
				System.out.print(i + ", ");
				count++;
			}
		}
		System.out.printf("\nCo %d so thuan nghich doc co 6 chu so", count);
	}
}
