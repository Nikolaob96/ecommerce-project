package com.ecommnjt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommnjt.model.ShoppingCartItem;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {
	
	@Query("select s from ShoppingCartItem s where shoppingcartid=?1 AND productid=?2")
	Optional<ShoppingCartItem> findByCartAndProduct(int cartId, int productId);
	
	@Modifying
	@Query(value = "insert into shoppingcartitem(id,quantity,shoppingcartid,productid) values (:id, :quantity, :cartid, :productid)",nativeQuery = true)
	void saveCartItem(@Param("id") int id, @Param("productid") int productid, @Param("cartid") int cartid, @Param("quantity") int quantity);

	@Modifying
	@Query(value = "delete s from shoppingcartitem s where shoppingcartid=:id",nativeQuery = true)
	void clearCart(@Param("id") int id);
}
