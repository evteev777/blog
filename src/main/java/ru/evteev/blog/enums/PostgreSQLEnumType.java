package ru.evteev.blog.enums;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class PostgreSQLEnumType extends org.hibernate.type.EnumType {

    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index,
        SharedSessionContractImplementor session) throws SQLException {

        Object valueName = (value != null) ? ((Enum) value).name() : null;
        statement.setObject(index, valueName, Types.OTHER);
    }
}