package sqltests;

import org.junit.Test;
import shared.BaseTest;
import shared.QueryEnum;

import java.sql.SQLException;

public class UpdateTest extends BaseTest {

    @Test
    public void updateRecordWhenIdIsOne() {
        try {
            String query = QueryEnum.UPDATE.getQuery()
                    + "help_category"
                    + QueryEnum.SET.getQuery()
                    + "name = 'Testing'"
                    + "parent_category_id = '007'"
                    + QueryEnum.WHERE.getQuery()
                    + "help_category_id = 1";
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
