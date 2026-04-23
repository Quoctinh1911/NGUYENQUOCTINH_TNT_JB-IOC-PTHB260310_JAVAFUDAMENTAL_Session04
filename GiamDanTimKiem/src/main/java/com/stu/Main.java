package com.stu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.print("\nNhập số cần tìm: ");
        int target = sc.nextInt();

        int posLinear = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                posLinear = i;
                break;
            }
        }

        if (posLinear != -1) {
            System.out.println("Tìm kiếm tuyến tính: Số " + target + " có tại vị trí " + (posLinear + 1));
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy");
        }

        int left = 0, right = n - 1;
        int posBinary = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                posBinary = mid;
                break;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (posBinary != -1) {
            System.out.println("Tìm kiếm nhị phân: Số " + target + " có tại vị trí " + (posBinary + 1));
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
        }

    }
}