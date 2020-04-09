package pers.hyu.bookmanagement.util;

/**
 * 上传文件重命名
 * 
 * @author hyu
 *
 */
public class FileUploadUtil {

	/**
	 * 按照指定格式重命名
	 * 
	 * @param bookId   图书的id号
	 * @param fileName 原始文件名
	 * @return 新文件名 eg： book0001-image.jpg
	 */
	public static String fileRename(String bookId, String fileName) {
		String newFileName = "";
		if (bookId != null && fileName != null) {
			int index = fileName.lastIndexOf('.');
			if (index != -1) {
				String fileExten = fileName.substring(index);

				newFileName = bookId + "-image" + fileExten;
			}else {
				newFileName = bookId;
			}

		}

		return newFileName;

	}

}
