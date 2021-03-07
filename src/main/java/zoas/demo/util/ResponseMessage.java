package zoas.demo.util;

public class ResponseMessage {
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String CREATED_USER = "회원가입 성공";
    public static final String INVALID_CREATED_USER = "회원 가입 정보가 잘못되었습니다.";
    public static final String INVALID_UPDATE_USER = "회원 수정 정보가 잘못되었습니다.";
    public static final String HAVE_NOT_UPDATE_USER = "회원 수정 정보가 없습니다.";
    public static final String UPDATE_PASSWORD_USER = "회원 비밀번호 정보 수정 성공";
    public static final String UPDATE_USER_CHECK = "비밀번호 정보 수정 회원 조회 성공";
    public static final String UPDATE_BRAND_USER = "회원 브랜드 정보 수정 성공";
    public static final String UPDATE_COMBINE_FROM_USER = "회원 통합 로그인 폼 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String AUTHORIZATION_FAIL = "인증 실패";

    public static final String ALREADY_USER ="이미 존재하는 회원 정보 입니다.";

    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";
    public static final String CURRENT_USER = "접근한 유저와 토큰의 유저가 같다.";
    public static final String NOT_CURRENT_USER = "접근한 유저와 토큰의 유저가 다르다.";

    public static final String NOT_FOUND_BRAND = "브랜드가 없습니다.";
    public static final String READ_BRAND = "브랜드 조회 성공";

    public static final String LIKE_SUCCCESS = "좋아요 성공";
    public static final String LIKE_FAIL = "좋아요 실패";
    public static final String LIKE_CANCEL_SUCCCESS = "좋아요 취소 성공";
    public static final String LIKE_CANCEL_FAIL = "좋아요 취소 실패";
    public static final String ALREADY_LIKE = "이미 좋아요 한 브랜드입니다.";
    public static final String NOT_LIKE = "좋아요 한 브랜드가 아닙니다.";
    public static final String NO_LIKE_BRAND = "좋아요 한 브랜드가 없습니다.";
    public static final String READ_LIKE_BRAND = "좋아요 한 브랜드 조회 성공";

    public static final String NO_LIKE_PRODUCT = "좋아요 한 상품이 없습니다.";
    public static final String READ_LIKE_PRODUCT = "좋아요 한 상품 조회 성공";

    public static final String READ_PRODUCT = "상품 조회 성공";
    public static final String NOT_PRODUCT = "없는 상품 입니다.";

    public static final String CLOSET_CREATE_SUCCESS = "옷장 아이템 등록 성공";
    public static final String CLOSET_CREATE_FAIL = "옷장 아이템 등록 실패";
    public static final String CLOSET_DELETE_SUCCESS = "옷장 아이템 삭제 성공";
    public static final String CLOSET_DELETE_FAIL = "옷장 아이템 삭제 실패";
    public static final String NOT_FOUNT_CLOSET = "옷장에 없는 아이템입니다.";
    public static final String CLOSET_SEARCH_PRODUCT_FAIL = "상품이 없습니다.";
    public static final String CLOSET_SEARCH_PRODUCT_SUCCESS = "상품 조회 성공.";

    public static final String PRODUCT_COMPARE_SUCCESS = "옷 사이즈 비교 성공";
    public static final String PRODUCT_COMPARE_FAIL = "옷 사이즈 비교 불가능";

    public static final String CLOSET_READ_SUCCESS = "카테고리 별 옷장 리스트 조회 성공";
    public static final String CLOSET_READ_FAIL = "카테고리 별 옷장 리스트 조회 실패";
    public static final String NO_CLOSET_ITEM= "옷장에 아이템이 없습니다.";


    public static final String BRADN_SEARCH_SUCCESS = "브랜드 검색 성공";

    public static final String INPUT_VALUE = "검색어를 입력하세요.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";

    /* product */
    public static final String READ_ALL_PRODUCTS = "상품 전체 조회 성공";
    public static final String READ_CATEGORY_PRODUCTS_NEW = "카테고리 상품 조회 신상순";
    public static final String READ_CATEGORY_PRODUCTS_POPULAR = "카테고리 상품 조회 인기순";
    public static final String READ_BRAND_PRODUCTS_NEW = "브랜드 상품 조회 신상순";
    public static final String READ_BRAND_PRODUCTS_POPULAR = "브랜드 상품 조회 인기순";
    public static final String READ_FOR_USER_REC_PRODUCTS = "특정 유저를 위한 상품 추천 리스트 조회 성공";
    public static final String READ_THREE_TO_RANDOM_THREE_BRANDS_PRODUCTS = "랜덤 3개 브랜드 별 인기 상품 리스트 조회 성공";

    public static final String READ_SEARCH_PRODUCTS_NEW = "상품 검색 조회 신상순";
    public static final String READ_SEARCH_PRODUCTS_POPULAR = "상품 검색 조회 인기순";

    public static final String NOT_FOUND_PRODUCTS = "상품 검색 결과가 없습니다";

    public static final String NOT_READ_PRODUCTS = "상품 리스트 조회 실패";
    public static final String INVALID_PRODUCTS_READ = "잘못된 상품 리스트 조회 URL";

    public static final String READ_FIRST_SEARCH_PAGE_PRODUCTS = "상품 검색 초기 화면, 상품 조회 완료";
}