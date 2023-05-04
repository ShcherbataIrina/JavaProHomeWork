package ua.ithillel.lesson22;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    public HeroDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHero(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Hero> mapHero(ResultSet result) throws SQLException {
        var students = new ArrayList<Hero>();
        while (result.next()) {
            students.add(Hero.builder()
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getDouble("height"))
                    .skinColor(result.getString("skin_color"))
                    .alignment(result.getString("alignment"))
                    .weight(result.getInt("weight"))
                    .publisherId(result.getLong("publisher_id"))
                    .build());
        }
        return students;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "select * from heroes where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHero(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = "insert into heroes (name, gender, eyeColor, race, hairColor, height, skinColor, alignment, weight, publisherId) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, hero.getName());
            statement.setString(2, hero.getGender());
            statement.setString(3, hero.getEyeColor());
            statement.setString(4, hero.getRace());
            statement.setString(5, hero.getHairColor());
            statement.setDouble(6, hero.getHeight());
            statement.setString(7, hero.getSkinColor());
            statement.setString(8, hero.getAlignment());
            statement.setInt(9, hero.getWeight());
            statement.setLong(10, hero.getPublisherId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set name = ?, gender = ?, eyeColor = ?, race = ?, hairColor = ?, height = ?, " +
                "publisherId = ?, skinColor = ?, alignment = ?, weight = ? where id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, hero.getName());
            statement.setString(2, hero.getGender());
            statement.setString(3, hero.getEyeColor());
            statement.setString(4, hero.getRace());
            statement.setString(5, hero.getHairColor());
            statement.setDouble(6, hero.getHeight());
            statement.setString(7, hero.getSkinColor());
            statement.setString(8, hero.getAlignment());
            statement.setInt(10, hero.getWeight());
            statement.setLong(9, hero.getPublisherId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        var sql = "delete from heroes where id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
