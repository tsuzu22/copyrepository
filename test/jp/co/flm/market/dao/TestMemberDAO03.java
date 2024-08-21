/**
 * jp.co.flm.market.test.TestMemberDAO03
 *
 * All Rights Reserved, Copyright Fujitsu Learning Media Limited
 */

package jp.co.flm.market.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.flm.market.entity.Member;

/**
 * insertMember()のテスト用クラスです。
 *
 * @author FLM
 * @version 1.0 YYYY/MM/DD
 */
public class TestMemberDAO03 {

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
            System.out.println(
                "使い方: java jp.co.flm.market.test.TestMemberDAO03 <会員ID> <パスワード>" + " <名前> <性別> <住所> <電話番号>");
            System.exit(1);
        }

        // コマンドライン引数を取得する。
        int i = 0;
        String memberId = args[i++];
        String password = args[i++];
        String memberName = args[i++];
        String gender = args[i++];
        String address = args[i++];
        String phone = args[i++];

        // テスト条件のオブジェクトを生成する
        Member member = new Member();
        member.setMemberId(memberId);
        member.setPassword(password);
        member.setMemberName(memberName);
        member.setGender(gender);
        member.setAddress(address);
        member.setPhone(phone);

        Connection con = null;
        try {
            // データベースに接続する。
            con = ConnectionManager.getConnection();

            // 単体テスト対象クラスのオブジェクトを生成する。
            MemberDAO mdao = new MemberDAO(con);

            // トランザクションを開始する
            con.setAutoCommit(false);

            // 単体テスト対象メソッドを呼び出す。
            mdao.registerMember(member);

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
