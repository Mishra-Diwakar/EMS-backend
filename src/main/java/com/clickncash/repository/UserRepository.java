package com.clickncash.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.clickncash.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where id = :userName")
	Optional<User> getUserByUserName(@Param("userName") Long userName);

	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where username = :userName")
	Optional<User> getUserByUserName2(@Param("userName") String userName);

	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where STATUS = :status")
	List<User> getAllActiveUsers(@Param("status") String status);
	
	@Query(nativeQuery = true, value = "select * from user where status='ACTIVE' AND isApiUser='1' OR isApiUser='4' order by id desc")
	List<User> findByIsApiUser(String value);
	
	@Query(nativeQuery = true, value = "select * from user where status='ACTIVE' AND isApiUser='1' AND parentId=?1 order by id desc")
	List<User> findByParendId(long parentId);
	
	@Query(nativeQuery = true, value = "select * from user where FIRSTNAME='Admin' LIMIT 1")
	User getAdminUser();
	
	@Query(nativeQuery = true, value = "select * from user where id=:id for update")
	User getUserForUpdate(@Param("id") Long id);

//	@Query(nativeQuery = true, value = "select * from user where username=?1 and email=?2")
	public List<User> findByUsernameAndEmail(String username, String email);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE user SET tPin=?1 WHERE otpNum=?2 AND email=?3 AND username=?4 AND password=?5")
	public void updateUserGenerateTPin(String tpin,String otpNum, String email,String username, String pasword);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User u SET u.profile=?1 WHERE u.email=?2 AND u.username=?3 AND u.id=?4")
	public void updateUserProfile(String profile,String email,String username, long id);
	
	@Query(nativeQuery = true, value = "SELECT * from user where email=?1 OR username=?2")
	List<User> isExists(String email ,String username);

	@Query(nativeQuery = true, value = "SELECT * from user where id!=?3 and (email=?1 OR username=?2)")
	List<User> isExists2(String email ,String username,Long id);

	@Query(nativeQuery = true, value = "SELECT * from user where isApiUser>=1 order by id desc")
	Page<User> getAllUsers(Pageable p);

	@Query(nativeQuery = true, value = "SELECT * FROM user where isApiUser in (1,2,3,4) order by id desc limit ?1")
	List<User> getUsers(Integer record);
	
	@Query(nativeQuery = true, value = "select * from user")
	List<User> findAllActiveUsers();
	
	User findByEmail(String email);
	
	@Query(nativeQuery = true, value = "select * from user")
	List<User> getUserIdAndUsername();

	@Query(nativeQuery = true, value = "select id from user where parentId=?1")
	List<Long> findAllChildOf(long parentId);

	@Query(nativeQuery = true, value = "select * from user where id in ?1 order by id desc")
	Page<User> findAllChilds(List<Long> childList, Pageable pageable);

	@Query(nativeQuery = true, value = "select * from user where usertype!=?1 order by id desc")
	Page<User> findAllUser(int i,Pageable pageable);

	Page<User> findAllByUserType(Long i, Pageable pageable);
	
	@Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.username = ?2")
	@Modifying
	public void updateFailedAttempts(int failAttempts, String username);
}