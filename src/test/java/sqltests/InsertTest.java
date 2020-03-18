package sqltests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import shared.BaseTest;
import shared.DBNameEnum;
import shared.QueryEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTest extends BaseTest {

    @Test
    public void insertInCategoryDBNewRecord() {
        String name = "test";
        String parent_category_id = "58";
        String resultSelect = null;
        try {
            String queryInsert = QueryEnum.INSERT.getQuery()
                    + QueryEnum.INTO.getQuery()
                    + DBNameEnum.CATEGORY.getName() + "(name, parent_category_id)"
                    + QueryEnum.VALUES.getQuery()
                    + "(" + "'" + name + "', " + "'" + parent_category_id + "'" + ")";
            stmt.executeQuery(queryInsert);

            String querySelect = QueryEnum.SELECT.getQuery()
                    + "parent_category_id"
                    + QueryEnum.FROM.getQuery()
                    + DBNameEnum.CATEGORY.getName()
                    + QueryEnum.WHERE.getQuery()
                    + "name = " + name;
            ResultSet result = stmt.executeQuery(querySelect);
            while (result.next()) {
                resultSelect = result.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(resultSelect).isEqualTo(parent_category_id);
    }
}
