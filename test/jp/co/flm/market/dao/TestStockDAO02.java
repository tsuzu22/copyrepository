/**
 * jp.co.flm.market.test.TestStockDAO02
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * updateStock()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestStockDAO02 {

    /** コマンドライン引数の数 */
    private static final int ARGS_SIZE = 2;

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
            System.out.println("使い方: java jp.co.flm.market.test.TestStockDAO02 <商品ID> <数量>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String productId = args[i++];
        int quantity = Integer.parseInt(args[i++]);

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            StockDAO sdao = new StockDAO(con);

            // トランザクションを開始する
            con.setAutoCommit(false);

            // 単体テスト対象メソッドを呼び出す。
            sdao.updateStock(productId, quantity);

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
