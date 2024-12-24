package Project;
import java.util.*;
//import java.util.InputMismatchException;

class BookList {
	private int BookNo;
	private String BookName;
	private String BookCategory ;
	private int BookRate;
///////////////////////////////////////////////////////////////////////////////////////	
	public BookList(int bookNo, String bookName, String bookCategory, int bookRate) 
	{
		super();
		BookNo = bookNo;
		BookName = bookName;
		BookCategory = bookCategory;
		BookRate = bookRate;
	}
///////////////////////////////////////////////////////////////////////////////////////
	public int getBookNo() {
		return BookNo;
	}

	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookCategory() {
		return BookCategory;
	}

	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}

	public int getBookRate() {
		return BookRate;
	}

	public void setBookRate(int bookRate) {
		BookRate = bookRate;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "BookList [BookNo=" + BookNo + ", BookName=" + BookName + ", BookCategory=" + BookCategory
				+ ", BookRate=" + BookRate + "]";
	}

	
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Books {
	
public static void main(String args[])
{
	List<BookList> c = new ArrayList<BookList>();
	c.add(new BookList(1, "Java", "Education", 1000));
	c.add(new BookList(2, "Hacking", "Education", 2000));
	c.add(new BookList(3, "AI", "Education", 1500));
	System.out.println("Enter book NO/book Name/book Type/book Rate");
	Scanner s = new Scanner(System.in);
//	Scanner s1 = new Scanner(System.in);
//	Scanner s2 = new Scanner(System.in);
//	Scanner s3 = new Scanner(System.in);
//	
	int ch;
	do {
		System.out.println("1 INSERT");
		System.out.println("2 DISPLAY");
		System.out.println("3 SEARCH");
		System.out.println("4 DELETE");
		System.out.println("5 UPDATE");
		System.out.println("6 Exit");
		System.out.print("Enter your choice: ");
		ch = s.nextInt();
		switch (ch) {
		case 1:
			System.out.print("Enter Book no: ");
			int bno = s.nextInt();
					  s.nextLine();
			System.out.print("Enter Book name: ");
			String bname = s.nextLine();
			System.out.print("Enter Book Category: ");
			String bcateg =s.nextLine();
			System.out.println("Enter Book Rate: ");
			int brate=s.nextInt();
			c.add(new BookList(bno, bname, bcateg, brate));
			System.out.println("----------------------------------------------------------");
			System.out.println("Book Inserted successfully");
			System.out.println("----------------------------------------------------------");
			break;

		case 2:
			System.out.println("-------------------------------------------------------------");
			Iterator<BookList> i = c.iterator();	//c is list name
			while (i.hasNext()) {
				BookList e = i.next();
				System.out.println(e);
			}
			System.out.println("-------------------------------------------------------------");
			break;

		case 3:
			boolean search = false;
			System.out.print("Enter Book Name: ");
			bname = s.next();
		
			i = c.iterator();			
			while (i.hasNext()) 
			{
				BookList e = i.next();
				if ( (e.getBookName().toLowerCase()).equals(bname.toLowerCase())) 
				{
					search = true;
//					System.out.println("*********"+search);
					System.out.println("--------------------------------------------------------------------");
					System.out.println(e);
				}
			}
			
			if (!search) {
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Book not found");
			}
			System.out.println("-------------------------------------------------------------");
			break;
		case 4:
			search = false;
			System.out.print("Enter Book Name which you want delete: ");
			bname = s.next();
			i = c.iterator();
			while (i.hasNext()) {
				BookList e = i.next();
				if ((e.getBookName().toLowerCase()).equals(bname.toLowerCase())) {
					i.remove();
					search = true;
				}
			}
			if (!search) {
				System.out.println("----------------------------------------------------");
				System.out.println("Book not found");
			} else {
				System.out.println("----------------------------------------------------");
				System.out.println("Book Deleted successfully ");
			}
			System.out.println("--------------------------------------------------------");
			break;

		case 5:
			search = false;
			System.out.print("Enter Book Name which you want Modify : ");
			bname = s.next();
			ListIterator<BookList> li = c.listIterator();
			while (li.hasNext()) {
				BookList e = li.next();
				if ((e.getBookName().toLowerCase()).equals(bname.toLowerCase())) {
					System.out.print("Enter Book No: ");
					bno = s.nextInt();
					System.out.print("Enter Book Name: ");
					bname = s.nextLine();
					System.out.println("Enter Book category: ");
					bcateg=s.nextLine();
					System.out.print("Enter Book Rate: ");
					brate = s.nextInt();
					li.set(new BookList(bno, bname, bcateg, brate));
					search = true;
				}
			}
			if (!search) {
				System.out.println("-----------------------");
				System.out.println("Book not found");
			} else {
				System.out.println("Book Updated successfully ");
			}
			System.out.println("-----------------------");
			break;
		
		
		case 6:
			System.exit(0);
			break;
	}
	}
	while (ch != 0);
	System.out.println("You Do Not Enter Any Value");
}
}
