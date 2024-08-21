/**
 * jp.co.flm.market.test.TestOrdersDAO02
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.flm.market.entity.Orders;
import jp.co.flm.market.entity.Product;

/**
 * getOrderList()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestOrdersDAO02 {

    /** コマンドライン引数の数 */
    private static final int ARGS_SIZE = 1;

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
            System.out.println("使い方: java jp.co.flm.market.test.TestOrdersDAO02 <会員ID>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String memberId = args[i];

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            OrdersDAO odao = new OrdersDAO(con);

            // 単体テスト対象メソッドを呼び出す。
            ArrayList<Orders> list = odao.getOrderList(memberId);
            for (Orders order : list) {
                Product product = order.getProduct();
                System.out.println("注文番号：" + order.getOrderId());
                System.out.println("日付：" + order.getOrderDate());
                System.out.println("商品コード：" + product.getProductId());
                System.out.println("商品名：" + product.getProductName());
                System.out.println("数量：" + order.getQuantity());
                System.out.println("購入時商品単価：" + product.getPrice());
                System.out.println("購入時商品ポイント：" + product.getPoint());
                System.out.println("小計ポイント：" + order.getSubTotalPoint());
                System.out.println("小計金額：" + order.getSubTotal());
                System.out.println();
            }
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
