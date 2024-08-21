/**
 * jp.co.flm.market.test.TestStockDAO01
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.flm.market.entity.Stock;

/**
 * selectStockForUpdate()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestStockDAO01 {

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
            System.out.println("使い方: java jp.co.flm.market.test.TestStockDAO01 <商品ID>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String productId = args[i];

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            StockDAO sdao = new StockDAO(con);

            // 単体テスト対象メソッドを呼び出す。
            Stock stock = sdao.selectStockForUpdate(productId);
            System.out.println("商品ID：" + stock.getProductId());
            System.out.println("在庫数：" + stock.getQuantity());
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
