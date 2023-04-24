import java.sql.*;

public class SqlConnectionExample {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=Hello;user=sa;password=adung2106;";

        try (Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM Table_1";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("ID") + " " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*Để liên kết SQL Server với chương trình phần mềm được viết bằng Java, bạn có thể sử dụng JDBC (Kết nối cơ sở dữ liệu Java), một API cho phép các ứng dụng Java truy cập cơ sở dữ liệu. Các bước sau đây để biết cách sử dụng JDBC để liên kết với SQL Server:

Tải và cài đặt trình điều khiển SQL Server JDBC.
Nhập các gói JDBC vào chương trình Java bằng cách sử dụng câu lệnh nhập.
Thiết lập kết nối với SQL Server bằng cách sử dụng lớp DriverManager. Bạn cần phải cung cấp thông tin đăng nhập của cơ sở dữ liệu, chẳng hạn như tên đăng nhập và mật khẩu, cũng như đường dẫn đến cơ sở dữ liệu.
Sau khi kết nối, bạn có thể tạo câu truy vấn SQL để thực hiện các thao tác trên cơ sở dữ liệu, chẳng hạn như chèn, cập nhật hoặc truy xuất dữ liệu.
Ví dụ dưới đây sử dụng JDBC để liên kết với SQL Server và truy vấn dữ liệu: (Code ở trên)
Trong đó, connectionUrlchứa thông tin kết nối với SQL Server, mydatabaselà tên cơ sở dữ liệu, myusernamevà mypasswordlà tên đăng nhập và mật khẩu để truy cập vào cơ sở dữ liệu. Sau đó, chương trình truy vấn dữ liệu từ bảng mytablevà hiển thị các giá trị trong cột column1và column2. */