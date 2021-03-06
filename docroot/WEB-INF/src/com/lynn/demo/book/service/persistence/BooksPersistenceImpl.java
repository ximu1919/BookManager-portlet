/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lynn.demo.book.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.lynn.demo.book.NoSuchBooksException;
import com.lynn.demo.book.model.Books;
import com.lynn.demo.book.model.impl.BooksImpl;
import com.lynn.demo.book.model.impl.BooksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author 10295
 * @see BooksPersistence
 * @see BooksUtil
 * @generated
 */
public class BooksPersistenceImpl extends BasePersistenceImpl<Books>
	implements BooksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BooksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByc_g",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByc_g",
			new String[] { Long.class.getName(), Long.class.getName() },
			BooksModelImpl.GROUPID_COLUMN_BITMASK |
			BooksModelImpl.COMPANYID_COLUMN_BITMASK |
			BooksModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByc_g",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bookses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findByc_g(long groupId, long companyId)
		throws SystemException {
		return findByc_g(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookses where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findByc_g(long groupId, long companyId, int start,
		int end) throws SystemException {
		return findByc_g(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookses where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findByc_g(long groupId, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((groupId != books.getGroupId()) ||
						(companyId != books.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Books>(list);
				}
				else {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first books in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws com.lynn.demo.book.NoSuchBooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books findByc_g_First(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBooksException, SystemException {
		Books books = fetchByc_g_First(groupId, companyId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBooksException(msg.toString());
	}

	/**
	 * Returns the first books in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books fetchByc_g_First(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByc_g(groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last books in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws com.lynn.demo.book.NoSuchBooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books findByc_g_Last(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchBooksException, SystemException {
		Books books = fetchByc_g_Last(groupId, companyId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBooksException(msg.toString());
	}

	/**
	 * Returns the last books in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books fetchByc_g_Last(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByc_g(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Books> list = findByc_g(groupId, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws com.lynn.demo.book.NoSuchBooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books[] findByc_g_PrevAndNext(long bookId, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchBooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByc_g_PrevAndNext(session, books, groupId, companyId,
					orderByComparator, true);

			array[1] = books;

			array[2] = getByc_g_PrevAndNext(session, books, groupId, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByc_g_PrevAndNext(Session session, Books books,
		long groupId, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bookses where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByc_g(long groupId, long companyId)
		throws SystemException {
		for (Books books : findByc_g(groupId, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(books);
		}
	}

	/**
	 * Returns the number of bookses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByc_g(long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "books.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "books.companyId = ?";

	public BooksPersistenceImpl() {
		setModelClass(Books.class);
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	@Override
	public void cacheResult(Books books) {
		EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey(), books);

		books.resetOriginalValues();
	}

	/**
	 * Caches the bookses in the entity cache if it is enabled.
	 *
	 * @param bookses the bookses
	 */
	@Override
	public void cacheResult(List<Books> bookses) {
		for (Books books : bookses) {
			if (EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
						BooksImpl.class, books.getPrimaryKey()) == null) {
				cacheResult(books);
			}
			else {
				books.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bookses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BooksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BooksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Books books) {
		EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Books> bookses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Books books : bookses) {
			EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
				BooksImpl.class, books.getPrimaryKey());
		}
	}

	/**
	 * Creates a new books with the primary key. Does not add the books to the database.
	 *
	 * @param bookId the primary key for the new books
	 * @return the new books
	 */
	@Override
	public Books create(long bookId) {
		Books books = new BooksImpl();

		books.setNew(true);
		books.setPrimaryKey(bookId);

		return books;
	}

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the books
	 * @return the books that was removed
	 * @throws com.lynn.demo.book.NoSuchBooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books remove(long bookId)
		throws NoSuchBooksException, SystemException {
		return remove((Serializable)bookId);
	}

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books that was removed
	 * @throws com.lynn.demo.book.NoSuchBooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books remove(Serializable primaryKey)
		throws NoSuchBooksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Books books = (Books)session.get(BooksImpl.class, primaryKey);

			if (books == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(books);
		}
		catch (NoSuchBooksException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Books removeImpl(Books books) throws SystemException {
		books = toUnwrappedModel(books);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(books)) {
				books = (Books)session.get(BooksImpl.class,
						books.getPrimaryKeyObj());
			}

			if (books != null) {
				session.delete(books);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (books != null) {
			clearCache(books);
		}

		return books;
	}

	@Override
	public Books updateImpl(com.lynn.demo.book.model.Books books)
		throws SystemException {
		books = toUnwrappedModel(books);

		boolean isNew = books.isNew();

		BooksModelImpl booksModelImpl = (BooksModelImpl)books;

		Session session = null;

		try {
			session = openSession();

			if (books.isNew()) {
				session.save(books);

				books.setNew(false);
			}
			else {
				session.merge(books);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BooksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						booksModelImpl.getOriginalGroupId(),
						booksModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						booksModelImpl.getGroupId(),
						booksModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey(), books);

		return books;
	}

	protected Books toUnwrappedModel(Books books) {
		if (books instanceof BooksImpl) {
			return books;
		}

		BooksImpl booksImpl = new BooksImpl();

		booksImpl.setNew(books.isNew());
		booksImpl.setPrimaryKey(books.getPrimaryKey());

		booksImpl.setBookId(books.getBookId());
		booksImpl.setGroupId(books.getGroupId());
		booksImpl.setCompanyId(books.getCompanyId());
		booksImpl.setUserId(books.getUserId());
		booksImpl.setUserName(books.getUserName());
		booksImpl.setCreateDate(books.getCreateDate());
		booksImpl.setModifiedDate(books.getModifiedDate());
		booksImpl.setBookName(books.getBookName());
		booksImpl.setPrice(books.getPrice());
		booksImpl.setBookSN(books.getBookSN());
		booksImpl.setContent(books.getContent());

		return booksImpl;
	}

	/**
	 * Returns the books with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books
	 * @throws com.lynn.demo.book.NoSuchBooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBooksException, SystemException {
		Books books = fetchByPrimaryKey(primaryKey);

		if (books == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return books;
	}

	/**
	 * Returns the books with the primary key or throws a {@link com.lynn.demo.book.NoSuchBooksException} if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books
	 * @throws com.lynn.demo.book.NoSuchBooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books findByPrimaryKey(long bookId)
		throws NoSuchBooksException, SystemException {
		return findByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Books books = (Books)EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
				BooksImpl.class, primaryKey);

		if (books == _nullBooks) {
			return null;
		}

		if (books == null) {
			Session session = null;

			try {
				session = openSession();

				books = (Books)session.get(BooksImpl.class, primaryKey);

				if (books != null) {
					cacheResult(books);
				}
				else {
					EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
						BooksImpl.class, primaryKey, _nullBooks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
					BooksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return books;
	}

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books fetchByPrimaryKey(long bookId) throws SystemException {
		return fetchByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns all the bookses.
	 *
	 * @return the bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Books> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKS;

				if (pagination) {
					sql = sql.concat(BooksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Books>(list);
				}
				else {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the bookses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Books books : findAll()) {
			remove(books);
		}
	}

	/**
	 * Returns the number of bookses.
	 *
	 * @return the number of bookses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the books persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lynn.demo.book.model.Books")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Books>> listenersList = new ArrayList<ModelListener<Books>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Books>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BooksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BOOKS = "SELECT books FROM Books books";
	private static final String _SQL_SELECT_BOOKS_WHERE = "SELECT books FROM Books books WHERE ";
	private static final String _SQL_COUNT_BOOKS = "SELECT COUNT(books) FROM Books books";
	private static final String _SQL_COUNT_BOOKS_WHERE = "SELECT COUNT(books) FROM Books books WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "books.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Books exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Books exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BooksPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"bookSN"
			});
	private static Books _nullBooks = new BooksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Books> toCacheModel() {
				return _nullBooksCacheModel;
			}
		};

	private static CacheModel<Books> _nullBooksCacheModel = new CacheModel<Books>() {
			@Override
			public Books toEntityModel() {
				return _nullBooks;
			}
		};
}