package tms.servlet.dao;

import tms.servlet.entity.Operation;

import java.sql.SQLException;
import java.util.List;

public interface OperationDao {
    void save(Operation operation) throws SQLException;

    List<Operation> findAllOperationByUserName(String username) throws SQLException;
}
