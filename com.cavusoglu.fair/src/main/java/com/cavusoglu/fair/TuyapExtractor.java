package com.cavusoglu.fair;

import org.apache.log4j.Logger;

/**
 * @author izel This class is used for executing specialized css queries on <a
 *         href=
 *         "http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015"
 *         >tuyap</a> for each attributes of fair
 */
public class TuyapExtractor {

	private Logger logger = Logger.getLogger(getClass());
	private DocumentSearcher documentSearcher;

	public TuyapExtractor() {
		documentSearcher = new DocumentSearcher();

	}

	public TuyapExtractor(DocumentSearcher documentSearcher) {
		this.documentSearcher = documentSearcher;
	}

	public String extractFairName(int i) {
		String cssPath = "> tr:nth-child(" + i
				+ ") > td:nth-child(2) > h5 > strong";
		String fairName = getDocumentSearcher().extractElementWithCssPAth(
				cssPath);
		logger.debug("Fair name has been extracted" + fairName);
		return fairName;

	}

	public String extractFairDate(int i) {
		String cssPath = "> tr:nth-child(" + i + ") > td:nth-child(3) > h5 > b";
		String extractElementWithCssPAth = getDocumentSearcher()
				.extractElementWithCssPAth(cssPath);
		logger.info("Fair date has been extracted" + extractElementWithCssPAth);
		return extractElementWithCssPAth;
	}

	public DateInterval extractDateInterval(int i)
			throws UnidentifiedMonthNameStrikeException {
		logger.info("extractDateInterval is working");
		return new DatePreparator().splitAndConvertToIso(extractFairDate(i));
	}

	public String extractFairDescription(int i) {
		String cssPath = "> tr:nth-child(" + i + ") > td:nth-child(2)";
		String fairDescription = getDocumentSearcher()
				.extractElementWithCssPAth(cssPath);
		logger.debug("Fair desc. has been extracted" + fairDescription);
		return fairDescription;
	}

	public String extractFairPlace(int i) {
		String cssPath = "> tr:nth-child(" + i
				+ ") > td:nth-child(3) > b > span";
		String fairPlace = getDocumentSearcher().extractElementWithCssPAth(
				cssPath);
		logger.debug("Fair place has been extracted" + fairPlace);
		return fairPlace;

	}

	DocumentSearcher getDocumentSearcher() {
		return documentSearcher;
	}

}
