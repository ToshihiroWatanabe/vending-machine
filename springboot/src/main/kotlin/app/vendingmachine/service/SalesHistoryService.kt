package app.vendingmachine.service

import app.vendingmachine.mapper.SalesHistoryMapper
import app.vendingmachine.model.SalesHistory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * 販売履歴に関するサービスクラスです。
 */
@Service
class SalesHistoryService @Autowired constructor(val salesHistoryMapper: SalesHistoryMapper) {

    fun findAll(): List<SalesHistory> {
        return salesHistoryMapper.findAll()
    }

    fun create(salesHistory: SalesHistory): Boolean {
        return salesHistoryMapper.create(salesHistory)
    }

    fun update(salesHistory: SalesHistory): Boolean {
        return salesHistoryMapper.update(salesHistory)
    }

    fun delete(id: String): Boolean {
        return salesHistoryMapper.delete(id)
    }

    fun deleteAll(): Boolean {
        return salesHistoryMapper.deleteAll()
    }
}