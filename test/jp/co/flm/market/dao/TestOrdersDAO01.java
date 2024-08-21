/**
 * jp.co.flm.market.test.TestOrdersDAO01
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.flm.market.entity.Orders;
import jp.co.flm.market.entity.Product;

/**
 * insertOrder()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestOrdersDAO01 {

    /** コマンドライン引数の数 */
    private static final int ARGS_SIZE = 6;

    /**
     * テスト実行mainメソッドです。
     *
     * @param args
     *            コマンドライン引数
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // コマンドライン引数を確認する。
        if (args.length != ARGS_SIZE) {
            System.out.println("使い方: java jp.co.flm.market.test.TestOrdersDAO01 <会員ID>"
                + " <クレジットカード番号> <商品ID> <注文数量> <単価> <ポイント>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String memberId = args[i++];
        String creditCardId = args[i++];
        String productId = args[i++];
        int quantity = Integer.parseInt(args[i++]);
        int price = Integer.parseInt(args[i++]);
        int point = Integer.parseInt(args[i++]);

        // テスト条件のオブジェクトを生成する
        Product product = new Product();
        product.setProductId(productId);
        product.setPrice(price);
        product.setPoint(point);

        Orders order = new Orders();
        order.setMemberId(memberId);
        order.setCreditCardId(creditCardId);
        order.setQuantity(quantity);
        order.setProduct(product);

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            OrdersDAO odao = new OrdersDAO(con);

            // トランザクションを開始する
            con.setAutoCommit(false);

            // 単体テスト対象メソッドを呼び出す。
            odao.insertOrder(order);

            // トランザクションを確定する
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            // データベース接続を閉じる。
            if (con != null) {
                con.close();
            }
        }
    }
}
