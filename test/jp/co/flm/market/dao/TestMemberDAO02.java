/**
 * jp.co.flm.market.test.TestMemberDAO02
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.flm.market.entity.Member;

/**
 * getMember()(引数1つ)のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestMemberDAO02 {

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
            System.out.println("使い方: java jp.co.flm.market.test.TestMemberDAO02 <会員ID>");
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
            MemberDAO mdao = new MemberDAO(con);

            // 単体テスト対象メソッドを呼び出す。
            Member member = mdao.getMember(memberId);
            System.out.println("会員ID：" + member.getMemberId());
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
