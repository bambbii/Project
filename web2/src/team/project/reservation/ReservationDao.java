package team.project.reservation;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;

import team.project.reservation.JtableProcess;

public class ReservationDao {
	
		//회원가입
		//구매자 
		//구매자에 대한 아이디, 비밀번호, 이름, 전화번호, 성별을 받는다.
		/*
		 * 	private String buyerid;
			private String password;
			private String name;
			private String tel;
			private String gender;
		 */
	private static ReservationDao reservationDao;
	private static JtableProcess table=new JtableProcess();
	
	public static ReservationDao getInstnace() {
		if(reservationDao==null) {
			reservationDao=new ReservationDao();
		}
		return reservationDao;
	}
	
	public String selectNameBuyer(String id) {
		 Connection con = ServiceUtil.getConnection();
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String sql="SELECT NAME FROM memberinfobuyer WHERE BUYERID=?";
	     try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return null;
		
	}
	public String selectNameSeller(String id) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT NAME FROM memberInfoseller WHERE SELLERID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return null;
		
	}
	
	public void searchRoomInfo(RoomInfo roomInfo, int houseno) {//방 정보
	      
	      Connection con = ServiceUtil.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT peoplecount, roomcount, bedcount,title,detailinfo,price FROM roominfomation  WHERE houseno   = ? ";
	      /*, detailinfo*/

	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, houseno);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            StringBuffer sb = new StringBuffer();
	            Reader rd = rs.getCharacterStream("DETAILINFO");
	            char[] buffer = new char[1024];
	            int byteRead;
	            while((byteRead=rd.read(buffer,0,1024))!=-1){
	            sb.append(buffer,0,byteRead);
	         };

	         roomInfo.gettitle().setText(rs.getString("TITLE"));
	         roomInfo.getpeopleCount().setText(String.valueOf("인원"+rs.getInt("PEOPLECOUNT")+"명"));
	         roomInfo.getRoomCount().setText(String.valueOf("침실"+rs.getInt("roomcount")+"개"));
	         roomInfo.getBedCount().setText(String.valueOf("침대"+rs.getInt("bedcount")+"개"));
	         roomInfo.getDetailInfo().setText(String.valueOf(sb));
	         roomInfo.getPrice().setText(String.valueOf(rs.getInt("price"))+"원 ");
	         }}
	       catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      } finally {
	         try {
	            if (con != null)
	               con.close();
	            if (pstmt != null)
	               pstmt.close();

	         } catch (Exception e2) {
	            // TODO: handle exception
	            e2.printStackTrace();
	         }
	      }}

	      
	
	public JtableProcess searchData(SearchBean bean) {//검색 테이블 뽑기
	      Connection con=ServiceUtil.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      ResultSetMetaData rsmd=null;
	      String sql="SELECT ro.houseno,TITLE,ADDR,PEOPLECOUNT,visstate 예약가능 FROM roominfomation RO,MEMBERINFOSELLER MI WHERE RO.HOUSENO=MI.HOUSENO AND ADDR LIKE '%'||?||'%' AND PEOPLECOUNT>=? AND VISSTATE='가능'";
	   
	      int row,col;
	      Object[][] data;
	      try {
	         pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	         pstmt.setString(1, bean.getAddr());
	         pstmt.setInt(2, bean.getCount());
	         rs=pstmt.executeQuery();
	         rs.last();
	         rsmd=rs.getMetaData();
	         col=rsmd.getColumnCount();
	         row=rs.getRow();
	         rs.beforeFirst();
	         data = new Object[row][col];
	         
	         int i=0;
	         while(rs.next()) {
	            for (int j = 0; j < col; j++) {
	               data[i][j] = rs.getString(j + 1);
	            }
	            i++;
	         }
	         String[] colName = new String[col];
	         for (int j = 0; j < colName.length; j++) {
	            colName[j] = rsmd.getColumnName(j + 1);
	         }
	         JtableProcess jtableProcess = new JtableProcess(colName,data);
	         return jtableProcess;
	         
	      } catch (Exception e) {
	         // TODO: handle exception
	      }finally {
	         try {
	            if(con!=null)con.close();
	            if(pstmt!=null)pstmt.close();
	         } catch (Exception e2) {
	            // TODO: handle exception
	         }
	      }return null;
	   }
	
	public static void reservationList(JTable jtb) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		//BUYERID	HOUSENO	CHECKIN	CHECKOUT	STATE	
		String sql = "select BUYERID,HOUSENO,CHECKIN,CHECKOUT,STATE from reservation " ;
		int row, col;
		Object[][] data;
		
		
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			
			rs.last();

			row = rs.getRow();
			rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			data = new Object[row][col];
			int i = 0;

			rs.beforeFirst();

			while (rs.next()) {
				for (int j = 0; j < col; j++) {
					data[i][j] = rs.getString(j + 1);
				}
				i++;
			}
			
			
			String[] colName = new String[col];
			for (int j = 0; j < colName.length; j++) {
				colName[j] = rsmd.getColumnName(j + 1);
			}
			
			JtableProcess jtableProcess = new JtableProcess(colName,data);
			jtb.setModel(jtableProcess);
			
			//pr.getJtable().setModel(jTableProcess);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	
	public static void MemberJoinBuyer(String buyerid, String password, String name
			,String tel, String gender) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into MemberInfoBuyer values(?,?,?,?,?)";
		MemberSeller bean = new MemberSeller();
	

		try {
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, buyerid);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, gender);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	// 구매자
		public static void MyPageBuyerDao(String buyerid, MypageBuyer mypageBuyer) {
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "SELECT buyerid,password, name, tel, gender FROM MemberInfoBuyer  WHERE buyerid   = ? ";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, buyerid);
				rs = pstmt.executeQuery();
				rs.next();

				mypageBuyer.getJtfbuyerid().setText(rs.getString("buyerid"));
				mypageBuyer.getJtfname().setText(rs.getString("name"));
				mypageBuyer.getJtftel().setText(rs.getString("tel"));
				mypageBuyer.setSgender(rs.getString("gender"));

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}

	

	//미사용
	/*	public static void MyPageBuyerDao(String buyerid, String password, String name
				,String tel, String gender) {
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			
			String sql = "insert into MemberInfoBuyer values(?,?,?,?,?)";
			MemberSeller bean = new MemberSeller();
		

			try {
				con.setAutoCommit(true);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, buyerid);
				pstmt.setString(2, password);
				pstmt.setString(3, name);
				pstmt.setString(4, tel);
				pstmt.setString(5, gender);
				pstmt.executeQuery();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}*/
		
	
/*	
	//구매자!!!
	public void MyPageBuyerDao(String buyerid,MypageBuyer mypageBuyer) {
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT buyerid, name, tel, gender FROM MemberInfoBuyer  WHERE buyerid   = ? ";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, buyerid);
			rs = pstmt.executeQuery();
			rs.next();
				memberSeller.setSellerid(rs.getString("sellerid"));
				memberSeller.setName(rs.getString("name"));
				memberSeller.setAddr(rs.getString("addr"));
				memberSeller.setTel(rs.getString("tel"));
				
				mypageseller.getJtfsellerid().setText(rs.getString("sellerid"));
				mypageseller.getJtfname().setText(rs.getString("name"));
				mypageseller.getJtfAddr().setText(rs.getString("addr"));
				mypageseller.getJtftel().setText(rs.getString("tel"));
				
				mypageBuyer.getJtfbuyerid().setText(rs.getString("buyerid"));
				mypageBuyer.getJtfname().setText(rs.getString("name"));
				mypageBuyer.getJtftel().setText(rs.getString("tel"));
				mypageBuyer.getJtfgender().setText(rs.getString("gender"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
*/
	public void insertSeller(JoinBean2 jb2) {///데이터베이스에 판매자 정보가 들어가게 해준다.
		String sql="insert into  memberinfoseller values(houseseq.nextval,?,?,?,?,?,?,'불가능',null)";
		PreparedStatement pstmt=null;
		Connection con = ServiceUtil.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, jb2.getBuyerid());
			pstmt.setString(2, jb2.getPassword());
			pstmt.setString(3, jb2.getName());
			pstmt.setString(5, jb2.getTel());
			pstmt.setString(6, jb2.getGender());
			pstmt.setString(4,jb2.getZipcode());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(pstmt !=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void insertBuyer(joinBean jb) {///데이터베이스에 구매자 정보가 들어가게해준다.
		String sql="insert into memberinfobuyer values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		Connection con = ServiceUtil.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, jb.getBuyerid());
			pstmt.setString(2, jb.getPassword());
			pstmt.setString(3, jb.getName());
			pstmt.setString(4, jb.getTel());
			pstmt.setString(5, jb.getGender());
			pstmt.executeUpdate();
					} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			e2.printStackTrace();
			}
		}
		
	}
	public void selectZip(String dong,JTable jtable){///검색에 맞는 주소값들을 보여준다.
		Connection con=ServiceUtil.getConnection();//연결객체
		PreparedStatement pstmt=null;//운반객체
		Object[][]data=null;
		StringBuffer sb=new StringBuffer();
		ResultSet rs=null;
		ResultSetMetaData rsmd;
		String []col;
		
		sb.append("SELECT SEQ,ZIPCODE,SIDO,GUGU,DONG,NVL(BUNJI,'')BUNJI ")
		  .append("FROM ZIPCODE ")
		  .append("WHERE DONG LIKE '%' || ? || '%' ");
		try {
			pstmt=con.prepareStatement(sb.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
			rsmd=rs.getMetaData();
			rs.last();
			data=new Object[rs.getRow()][rsmd.getColumnCount()];
			int i=0;			
			rs.beforeFirst();
			while(rs.next()) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					data[i][j]=rs.getString(j+1);
				}
				i++;
			}
			col=new String[rsmd.getColumnCount()];
			for (int j = 0; j < col.length; j++) {
				col[j]=rsmd.getColumnName(j+1);
			}
			table=new JtableProcess(col, data);
			jtable.setModel(table);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	public String getSbean(int row) {///jtable의 값을 1행부터 차례대로 뿌려준다.
		return (String)table.getValueAt(row, 0);
	}
	public addrBean selectBean(String sbean) {///주소정보들을 데이터베이스에 저장하여 주소찾기버튼을 눌렀을때 값이 들어가게 해준다.
		Connection con=ServiceUtil.getConnection();///연결객체
		PreparedStatement pstmt=null;//운반객체
		ResultSet rs=null;
		addrBean addrBean=new addrBean();
		try {
			String sql="SELECT ZIPCODE,SIDO,GUGU,DONG,NVL(BUNJI,'')BUNJI FROM ZIPCODE WHERE SEQ=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbean));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				addrBean.setZipcode(rs.getString(1));
				addrBean.setSido(rs.getString(2));
				addrBean.setGugun(rs.getString(3));
				addrBean.setDong(rs.getString(4));
				addrBean.setBunji(rs.getString(5));				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return addrBean;
	}
	public String buyeridserch(String buyerid,String buyerpassword) {///구매자의 테이블을 통해 구매자의 로그인 정보를 비교해서 맞는값이 들어가게 해줌
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select buyerid,password from memberinfobuyer where buyerid=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, buyerid);
			pstmt.setString(2, buyerpassword);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return buyerid;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(rs!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			e2.printStackTrace();
			}
		}return "";
	
	}
	public String selleridserch(String sellerid,String sellerpassword) {///판매자의 테이블을 통해 구매자의 로그인 정보를 비교해서 맞는값이 들어가게 해줌
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select sellerid,password from memberinfoseller where sellerid=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, sellerid);
			pstmt.setString(2, sellerpassword);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return sellerid;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(rs!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			e2.printStackTrace();
			}
		}return "";
	}
	
	public static void MyPageSellerDao(String sellerid, MypageSeller mypageseller) { //
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT sellerid, password,name, addr, tel,gender,visstate FROM MemberInfoSeller WHERE sellerid  = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sellerid);
			rs = pstmt.executeQuery();
			rs.next();

			mypageseller.getJtfsellerid().setText(rs.getString("sellerid"));
			mypageseller.setPasswordChange(rs.getString("password"));
			mypageseller.getJtfname().setText(rs.getString("name"));
			mypageseller.getJtfAddr().setText(rs.getString("addr"));
			mypageseller.getJtftel().setText(rs.getString("tel"));
			mypageseller.setSgender(rs.getString("gender"));
			mypageseller.setVstate(rs.getString("visstate"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
public static void sellerModify(MypageSeller mypageSeller) {
		
		
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="update memberinfoseller set NAME=?,TEL=?,GENDER=?,ADDR=? where sellerid=? "; 

		
		try {
			con.setAutoCommit(true);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mypageSeller.getJtfname().getText());
			pstmt.setString(2, mypageSeller.getJtftel().getText());
			pstmt.setString(3, mypageSeller.getSgender());
			if(mypageSeller.getJtfaddr2().getText().equals("상세주소 입력")) {
			pstmt.setString(4, mypageSeller.getJtfAddr().getText());
			}else {
		    pstmt.setString(4, mypageSeller.getJtfAddr().getText()+mypageSeller.getJtfaddr2().getText());
			}
			pstmt.setString(5, mypageSeller.getJtfsellerid().getText());
			
			rs = pstmt.executeQuery();

		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	public void buyerMember(MypageBuyer buyer) {//
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update MemberInfoBuyer set BUYERID = ?, "
				+ "PASSWORD = ?, NAME = ?, TEL = ?,"
				+ "GENDER = ? WHERE BUYERID = ? ";

		try {
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, buyer.getJtfbuyerid().getText());
			pstmt.setString(2, buyer.getJlbuyerpass().getText());
			pstmt.setString(3, buyer.getJtfname().getText());
			pstmt.setString(4, buyer.getJtftel().getText());
			pstmt.setString(5, buyer.getSgender());
			pstmt.setString(6, buyer.getJtfbuyerid().getText());
		
			rs = pstmt.executeQuery();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	public static void sellerPassword(String id, String pass) {//
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update MemberInfoSeller set password = ? WHERE sellerid = ? ";

		try {
			System.out.println(id);
			System.out.println(pass);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			pstmt.executeQuery();
			con.setAutoCommit(true);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	public static void sellerMember(MypageSeller seller) {//
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update MemberInfoSeller set sellerid = ?, "
				+ "name = ?, addr = ?,"
				+ "tel = ?, gender = ?  WHERE sellerid = ? ";

		try {
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller.getJtfsellerid().getText());
			pstmt.setString(2, seller.getJtfname().getText());
			pstmt.setString(3, seller.getJtfAddr().getText());
			pstmt.setString(4, seller.getJtftel().getText());
			pstmt.setString(5, seller.getSgender());
			pstmt.setString(6, seller.getJtfsellerid().getText());
		
			rs = pstmt.executeQuery();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	public static void detaildataChange(MypageSeller seller) {
		Connection con = ServiceUtil.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	     // HOUSENO	PEOPLECOUNT	ROOMCOUNT	BEDCOUNT	DETAILINFO	TITLE	

	      String sql = "update roominfomation set peoplecount";
	}
	
	
	public static void detaildata(String sellerid, MypageSeller mypageSeller) {
	      Connection con = ServiceUtil.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      String sql = "SELECT ri.PEOPLECOUNT PEOPLECOUNT, ri.ROOMCOUNT ROOMCOUNT, ri.BEDCOUNT BEDCOUNT, ri.DETAILINFO DETAILINFO,ri.TITLE TITLE,mi.visstate visstate "
	            + "FROM memberinfoseller mi, roominfomation ri  " + "WHERE mi.sellerid   = ? and mi.houseno=ri.houseno";
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, sellerid);
	         rs = pstmt.executeQuery();
	         rs.next();

	         mypageSeller.getJtftitle().setText(rs.getString("TITLE"));
	         mypageSeller.setPcount(Integer.parseInt(rs.getString("PEOPLECOUNT")));
	         mypageSeller.setRcount(Integer.parseInt(rs.getString("ROOMCOUNT")));
	         mypageSeller.setBcount(Integer.parseInt(rs.getString("BEDCOUNT")));
	         mypageSeller.getJta().setText(rs.getString("DETAILINFO"));
	         mypageSeller.setVstate(rs.getString("visstate"));
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      } finally {
	         try {
	            if (con != null)
	               con.close();
	            if (pstmt != null)
	               pstmt.close();

	         } catch (Exception e2) {
	            // TODO: handle exception
	            e2.printStackTrace();
	         }
	      }
	   }
	public static boolean buyerIdCheck(String buyerid) {///buyerid체크할때 사용
		boolean state=false;
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select buyerid from memberinfobuyer where buyerid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, buyerid);
			rs=pstmt.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return false;
	}
	
	public static boolean sellerIdCheck(String sellerid) {///sellerid 체크
		boolean state=false;
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select sellerid from memberinfoseller where sellerid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, sellerid);
			rs=pstmt.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return false;
	}
	
	   public ReservationBean searchReservation(int row) {//바꿔야됨
		      
		      Connection con = ServiceUtil.getConnection();
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      
		      String sql = "SELECT BUYERID, HOUSENO, CHECKIN, CHECKOUT, STATE FROM reservation  WHERE houseno   = ? ";
		      /*, detailinfo*/

		      
		      try {
		         pstmt = con.prepareStatement(sql);
		         pstmt.setInt(1, row);
		         rs = pstmt.executeQuery();
		         
		         ReservationBean reservationBean=new ReservationBean();
					if(rs.next()) {
						reservationBean.setBuyerid(rs.getString("buyerid"));
						reservationBean.setHouseno(rs.getInt("houseno"));
						reservationBean.setCheckin(rs.getString("checkin"));
						reservationBean.setCheckout(rs.getString("checkout"));
						reservationBean.setState(rs.getString("state"));
		
					}	
		         return reservationBean;
		         }
		       catch (Exception e) {
		         // TODO: handle exception
		         e.printStackTrace();
		         return null;
		      } finally {
		         try {
		            if (con != null)
		               con.close();
		            if (pstmt != null)
		               pstmt.close();

		         } catch (Exception e2) {
		            // TODO: handle exception
		            e2.printStackTrace();
		         }
		         
		      }
		   }   
	
	   public void insertReservation(RoomInfo roomInfo) {
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			
			String sql = "insert into reservation values(?,?,?,?,?,?,?)";
			
		

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, roomInfo.getId());
				pstmt.setInt(2, roomInfo.getRow());
				pstmt.setString(3, roomInfo.getInText().getText());
				pstmt.setString(4, roomInfo.getOutText().getText());
				pstmt.setString(5, "승인대기중");
				pstmt.setInt(6, Integer.parseInt(roomInfo.getJtfPCount().getText().split("명")[0]));
				pstmt.setInt(7, Integer.parseInt(roomInfo.getPrice().getText().split("원")[0]));
				pstmt.executeQuery();
				con.setAutoCommit(true);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			
			
		}
	   }
	   
	   public static void buyerPassword(String id, String pass) {//////////
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "update MemberInfoBuyer set password = ? WHERE buyerid = ? ";

			try {
				System.out.println(id);
				System.out.println(pass);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pass);
				pstmt.setString(2, id);
				pstmt.executeQuery();
				con.setAutoCommit(true);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}
	   
	   public static void buyerModify(MypageBuyer mypageBuyer) {
			
			System.out.println("히릿");
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql="update memberinfobuyer set NAME=?,TEL=?,GENDER=? where buyerid=? "; 

			
			try {
				con.setAutoCommit(true);
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mypageBuyer.getJtfname().getText());
				pstmt.setString(2, mypageBuyer.getJtftel().getText());
				pstmt.setString(3, mypageBuyer.getSgender());
				pstmt.setString(4, mypageBuyer.getId());
		
			
				
				rs = pstmt.executeQuery();

			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		}

	public static void myReservation(MypageBuyer mypageBuyer) {
			
			Connection con = ServiceUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql="select houseno,checkin,checkout,state,people,rsprice from reservation where buyerid=? "; 

			
			try {
				con.setAutoCommit(true);
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mypageBuyer.getId());
				rs = pstmt.executeQuery();
				rs.next();
				
				mypageBuyer.getJlapprove1().setText(rs.getString("state"));
				mypageBuyer.getJlpeople1().setText(rs.getString("people"));
				mypageBuyer.getJlcost1().setText(rs.getString("rsprice"));
				mypageBuyer.getJlservno1().setText(rs.getString("houseno"));
				mypageBuyer.getJlcheckin1().setText(rs.getString("checkin"));
				mypageBuyer.getJlcheckout1().setText(rs.getString("checkout"));

		
			
				
				rs = pstmt.executeQuery();

			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if (con != null)
						con.close();
					if (pstmt != null)
						pstmt.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

			
			
		}

	public static void buyerDetailModifyState(MypageSeller mypageSeller) {
		
		Connection con = ServiceUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		String sql= "update memberinfoseller set visstate=? where sellerid=? ";
	  
		try {
			con.setAutoCommit(true);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mypageSeller.getVstate());
			pstmt.setString(2, mypageSeller.getId());
	
			
			pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
	
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	}
	}
	
	public static void buyerDetailModify(MypageSeller mypageSeller) {
	      Connection con = ServiceUtil.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      
	      String sql= "update roominfomation set title=?,PEOPLECOUNT=?, ROOMCOUNT=?, BEDCOUNT=?, DETAILINFO=?, PRICE=?  where houseno=(select houseno from memberinfoseller where sellerid= ?) ";
	      
	      try {
	         con.setAutoCommit(true);
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, mypageSeller.getJtftitle().getText());
	         pstmt.setString(2, mypageSeller.getJlpcount().getText());
	         pstmt.setString(3, mypageSeller.getJlrcount().getText());
	         pstmt.setString(4, mypageSeller.getJlbcount().getText());
	         pstmt.setString(5, mypageSeller.getJta().getText());
	         pstmt.setString(6, mypageSeller.getJtfprice().getText());
	         pstmt.setString(7, mypageSeller.getId());
	         
	         pstmt.executeUpdate();
	         
	      
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
	         try {
	            if (con != null)
	               con.close();
	            if (pstmt != null)
	               pstmt.close();

	         } catch (Exception e2) {
	            // TODO: handle exception
	            e2.printStackTrace();
	         }
	   }
	   
	   }
	
	 public void updateReservation(String id,int houseno,String state) {
		    Connection con=ServiceUtil.getConnection();
		    PreparedStatement pstmt=null;
		    String sql= "update reservation set STATE='"+state+"' where houseno="+houseno+" and BUYERID=lower('"+id+"')";    
		    System.out.println(sql);
		    try {       
		      pstmt=con.prepareStatement(sql);
		      con.setAutoCommit(true);
		      pstmt.executeQuery();
		   } catch (Exception e) {
		      // TODO: handle exception
		      e.printStackTrace();
		   }finally {
		      try {
		         if(con!=null)con.close();
		         if(pstmt!=null)pstmt.close();
		         
		      } catch (Exception e2) {
		         e2.printStackTrace();
		      }
		   }

		  
		  }
}



