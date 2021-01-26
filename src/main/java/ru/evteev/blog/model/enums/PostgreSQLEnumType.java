package ru.evteev.blog.model.enums;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class PostgreSQLEnumType extends org.hibernate.type.EnumType {

    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index,
        SharedSessionContractImplementor session) throws SQLException {
        if (value != null) {
            statement.setObject(index, ((Enum) value).name(), Types.VARCHAR);
        } else {
            statement.setObject(index, null, Types.OTHER);
        }
    }
}