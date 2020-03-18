package sqltests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import shared.BaseTest;
import shared.DBNameEnum;
import shared.QueryEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest extends BaseTest {

    @Test
    public void selectAllTest() {
        ResultSet result = null;
        try {
            String query = QueryEnum.SELECT.getQuery()
                    + "*" + QueryEnum.FROM.getQuery()
                    + DBNameEnum.CATEGORY.getName();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    public void selectNameByIdFromCategoryDBTest() {
        String nameFromDB = null;
        try {
            String query = QueryEnum.SELECT.getQuery()
                    + "name"
                    + QueryEnum.FROM.getQuery()
                    + DBNameEnum.CATEGORY.getName()
                    + QueryEnum.WHERE.getQuery()
                    + "help_category_id = 1";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                nameFromDB = result.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(nameFromDB).isEqualTo("Geographic");
    }

    @Test
    public void selectParentCategoryIdByNameFromCategoryDBTest() {
        String parentCategoryIdFromDB = null;
        try {
            String query = QueryEnum.SELECT.getQuery()
                    + "parent_category_id"
                    + QueryEnum.FROM.getQuery()
                    + DBNameEnum.CATEGORY.getName()
                    + QueryEnum.WHERE.getQuery()
                    + "name = 'Geographic'";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                parentCategoryIdFromDB = result.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(parentCategoryIdFromDB).isEqualTo("0");
    }
}
